package com.myapp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myapp.lms.dto.AuthenticationResponse;
import com.myapp.lms.dto.LoginVO;
import com.myapp.lms.dto.ResponseVO;
import com.myapp.lms.dto.UserDetailsDTO;
import com.myapp.lms.model.Book;
import com.myapp.lms.model.User;
import com.myapp.lms.service.BookService;
import com.myapp.lms.service.UserService;
import com.myapp.lms.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LmsController {

	@Autowired
	public UserService userService;

	@Autowired
	public BookService bookService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	public JwtUtil jwtUtil;

	/*
	 * This End point is responsible for fetching all books available in our
	 * database.
	 */
	
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}
	
	/*
	 * This End point is responsible Authentication.
	 */

	@PostMapping("/login")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public LoginVO login(@RequestBody UserDetailsDTO userDetails) {
		User user = userService.getUserDetails(userDetails.getUserName());
		LoginVO vo = new LoginVO();
		if (null != user) {
			System.out.println(user.toString());
			vo.setAuthenticatedString("Authenticated");
		} else {
			vo.setAuthenticatedString("Not Authenticated");
		}
		return vo;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST, produces = "application/json")
	public AuthenticationResponse authenticate(@RequestBody UserDetailsDTO userDetails) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUserName(), userDetails.getPassword()));
		}catch (BadCredentialsException e) {
			System.out.println(e);
			throw new Exception("bad credentials",e);
		}
		User user = userService.getUserDetails(userDetails.getUserName());
		String jwtToken = jwtUtil.generateToken(user);
		AuthenticationResponse respose = new AuthenticationResponse(jwtToken);
		return respose;
	}
	/*
	 * This End point is responsible for updating book details
	 */
	
	@PutMapping("/updateBook")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseVO updateBooks(@RequestBody Book book) {

		ResponseVO vo = new ResponseVO();
		Book updatedBook = bookService.updateBooks(book);
		if (null != updatedBook) {
			vo.setResponseString("sucess");
		} else {
			vo.setResponseString("Failed To Update");
		}
		return vo;
	}

	/*
	 * This End point is responsible for adding new Books.
	 */
	
	@PostMapping("/addBook")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseVO addBooks(@RequestBody Book book) {

		ResponseVO vo = new ResponseVO();
		Book newBook = bookService.saveBook(book);
		if (null != newBook) {
			vo.setResponseString("sucess");
		} else {
			vo.setResponseString("Failed To add");
		}
		return vo;
	}

	/*
	 * This End point is responsible for deleting books by ID.
	 */
	
	@DeleteMapping("/deleteBooks/{bookID}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseVO deleteBooks(@PathVariable("bookID") int bookID) {
		String msg = bookService.deleteBook(bookID);
		ResponseVO vo = new ResponseVO();
		vo.setResponseString(msg);
		return vo;
	}

}
package com.myapp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.lms.dto.LoginVO;
import com.myapp.lms.dto.ResponseVO;
import com.myapp.lms.dto.UserDetails;
import com.myapp.lms.model.Book;
import com.myapp.lms.model.User;
import com.myapp.lms.service.BookService;
import com.myapp.lms.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LmsController {

	@Autowired
	public UserService userService;

	@Autowired
	public BookService bookService;

	/*
	 * This End point is responsible for fetching all books available in our
	 * database.
	 */
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}

	/*
	 * This End point is responsible Authentication.
	 */

	@PostMapping("/login")
	public LoginVO login(@RequestBody UserDetails userDetails) {
		User user = userService.getUserDetails(userDetails);
		LoginVO vo = new LoginVO();
		if (null != user) {
			System.out.println(user.toString());
			vo.setAuthenticatedString("Authenticated");
		} else {
			vo.setAuthenticatedString("Not Authenticated");
		}
		return vo;
	}

	/*
	 * This End point is responsible for updating book details
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/updateBook")
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addBook")
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/deleteBooks/{bookID}")
	public ResponseVO deleteBooks(@PathVariable("bookID") int bookID) {
		String msg = bookService.deleteBook(bookID);
		ResponseVO vo = new ResponseVO();
		vo.setResponseString(msg);
		return vo;
	}

}
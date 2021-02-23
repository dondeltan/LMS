package com.myapp.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.lms.model.Book;
import com.myapp.lms.repository.BookRepository;

@Service
public class BookService {
	

	@Autowired
	public BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> li = new ArrayList<Book>();
		bookRepository.findAll().forEach(li::add);
		return li;
	}

	public Book updateBooks(Book book) {
		Book oldBook = bookRepository.findById(book.getBookID()).orElse(null);
		Book updatedBook = null;
		if(null!=oldBook) {
		updatedBook = bookRepository.save(oldBook.updateBook(book));
		}
		return updatedBook;
	}

	public Book saveBook(Book book) {
		Book newBook = bookRepository.save(book);
		return newBook;
	}

	public String deleteBook(int bookID) {
		Book book = bookRepository.findById(bookID).orElse(null);
		if(null!=book) {
		bookRepository.deleteById(bookID);
		return "Success";
		}
		return "BookNot Found to Delete";
	}
	


}

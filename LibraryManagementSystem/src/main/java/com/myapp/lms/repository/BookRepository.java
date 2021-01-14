package com.myapp.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.lms.model.Book;


@Repository
public interface  BookRepository extends CrudRepository<Book, Integer> {
	
	//List<Book> findBook(String criteria, String type);
	
}

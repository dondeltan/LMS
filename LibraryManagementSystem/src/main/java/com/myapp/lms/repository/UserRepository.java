package com.myapp.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.myapp.lms.model.User;

public interface UserRepository extends CrudRepository<User, Integer> { 
	
	public User findByUserName(String UserName);
}

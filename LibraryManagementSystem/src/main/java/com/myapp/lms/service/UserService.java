package com.myapp.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.lms.dto.UserDetailsDTO;
import com.myapp.lms.model.User;
import com.myapp.lms.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public User getUserDetails(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}
	
	
}

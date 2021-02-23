package com.myapp.lms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp.lms.model.User;
import com.myapp.lms.repository.UserRepository;

@Service
public class UserDetailService  implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if(user==null) {
			throw new UsernameNotFoundException("userName not Found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPass(), getGrantedAuthorizedUser(user));
	}
	private Collection<GrantedAuthority> getGrantedAuthorizedUser(User user) {
		Collection<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		if(user.getRole().getName().equals("admin")) {
			grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthority;
	}
	
}

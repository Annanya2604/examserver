package com.exam.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
     
	@Autowired
	private UserRepository userRepository;
	
	//to find user
	@Override
	public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepository.findByUsername(username);
		//String password = "1234";
		if(user==null ) {
			System.out.println("User not found");
			throw new ResourceNotFoundException("No user found");
		}
		return user;
//		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}

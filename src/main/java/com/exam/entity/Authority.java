package com.exam.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
	private String authority;//object
	
	public Authority(String authority) { //constructor
		super();
		this.authority = authority;  
	}

	@Override
	public String getAuthority() {   //method
		return this.authority;
	}
	
	

}

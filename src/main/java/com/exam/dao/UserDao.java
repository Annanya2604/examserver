package com.exam.dao;

import com.exam.entity.Role;
import com.exam.entity.Section;
import com.exam.entity.Standard;

public class UserDao {
	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private StandardDao standard;
	private SectionDao section;
	private RoleDao role;
	
	public UserDao() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public StandardDao getStandard() {
		return standard;
	}
	public void setStandard(StandardDao standard) {
		this.standard = standard;
	}
	public SectionDao getSection() {
		return section;
	}
	public void setSection(SectionDao section) {
		this.section = section;
	}
	public RoleDao getRole() {
		return role;
	}
	public void setRole(RoleDao role) {
		this.role = role;
	}
	
	
	
}

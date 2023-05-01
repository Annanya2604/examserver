package com.exam.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")//tb_users
public class User implements UserDetails {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//PK
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
		
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
    private String lastname;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne
	private Standard standard;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Section section;
	
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Role role;
	
    
    @Column(name = "deleted")
    private Boolean deleted = false;
   // private boolean isdeleted = Boolean.FALSE;
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
//	@JsonIgnore
//	private Set<UserRole> userRoles=new HashSet<>();
	
	
	public Boolean getDeleted() {
		return deleted;
	}





	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}





	public User() {
		
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





	public Standard getStandard() {
		return standard;
	}





	public void setStandard(Standard standard) {
		this.standard = standard;
	}





	public Section getSection() {
		return section;
	}





	public void setSection(Section section) {
		this.section = section;
	}





	public Role getRole() {
		return role;
	}





	public void setRole(Role role) {
		this.role = role;
	}





	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set=new HashSet<>();
		set.add(new Authority(role.getRoleName()));
		return set;
}





	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}





	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}





	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}





	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}





	
	
	
	
}

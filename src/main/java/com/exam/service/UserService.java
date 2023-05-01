package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.exam.dao.UserDao;
import com.exam.entity.ChangePassword;
import com.exam.entity.User;

public interface UserService {
      
	//creating user
	public User addUser(UserDao userDao) throws Exception;
	public User updateUser(UserDao userDao,Long id);
	public List<User> getUser();
	public User getUserById(Long id);
	public void deleteUserById(Long id);
	//public void deleteByStandardId(Long standardId);
	public List<User> deleteByStandardId(Long standardId);
	public List<User> deleteBySectionId(Long sectionId);
	public List<User> findUsersExceptAdmin();
	public User findUser(String username);
	public String changePass(ChangePassword changepassword);
	public Long countuser(User user);
}

package com.exam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dao.SectionDao;
import com.exam.dao.StandardDao;
import com.exam.dao.UserDao;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
     //creating user
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	 public ResponseEntity<?> addUser(@RequestBody UserDao userDao) throws Exception
	 {   
		 User u=this.userService.addUser(userDao);
		 return ResponseEntity.ok(u);
	     
	 }
	 
	@GetMapping("/get")
	 public List<User> getUser() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return userService.getUser();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	@GetMapping("/getuser")
	 public List<User> getUserExceptAdmin() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return userService.findUsersExceptAdmin();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	 
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		  userService.deleteUserById(id);
		  return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
	 }
	
	@GetMapping("/get/{id}")
	 private User getUser(@PathVariable("id") Long id){
		 return userService.getUserById(id);
	 }
	 
	@PutMapping("/update/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody UserDao userDao){
		 
		 return new ResponseEntity<User>(userService.updateUser(userDao, id), HttpStatus.OK);
		 
	 }
	
	@GetMapping("/countuser")
	 private Long getcountuser(User user) {
		 Long count=userService.countuser(user);
		 return count;
	 }
	
	 
}

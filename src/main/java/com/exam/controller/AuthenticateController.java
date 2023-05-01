package com.exam.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtils;
import com.exam.dao.UserDao;
import com.exam.entity.ChangePassword;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.service.UserDetailsServiceImpl;
import com.exam.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin("*")
public class AuthenticateController {
	
	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 
	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 @Autowired
	 private UserService userservice;
	 
	 
	 
	 
	 
	 //generate token
	// @CrossOrigin("*")
	 //@CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/generate-token")
	 public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		 try {
	            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
	            
	        } catch (Exception ex) {
	            throw new Exception("invalid username/password");
	        }
//			return jwtUtils.generateToken(jwtRequest.getUsername());
		 
		//authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		 
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token=this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		 
			
		}
		 
	 
	 //authenticate the user
     private void authenticate(String username,String password) throws Exception {
    	 try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)) ;
    	 }
    	 catch(DisabledException e) {
    		 throw new Exception("User Disabled"+e.getMessage());
    		 
    	 }
    	 catch(BadCredentialsException e) {
    		 throw new Exception("Invalid Credentials"+e.getMessage());
    	 }
     }
     
     //Principal interface -return details of the person with authentication token
   //@CrossOrigin(origins = "http://localhost:4200")
     @GetMapping("/current-user")
     public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    	 
     }
     @PostMapping("/forgot-password")
	 public User getUserByUsername(@RequestParam("username") String username) {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return userservice.findUser(username);
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
     
     @PutMapping("/change-password")
     public ResponseEntity<String> changePassword(@RequestBody ChangePassword changepassword){
    	 //User u=this.userService.addUser(userDao);
    	 String cp=userservice.changePass(changepassword);
		 return ResponseEntity.ok(cp);
     }
     
     
}

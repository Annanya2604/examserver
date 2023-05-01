package com.exam.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.config.JwtAuthenticationFilter;
import com.exam.dao.UserDao;
import com.exam.entity.Role;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;
import com.exam.entity.ChangePassword;
import com.exam.entity.Email;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.QuestionsRepository;
import com.exam.repository.RoleRepository;
import com.exam.repository.SectionRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.StudentQuestionAnswerRepository;
import com.exam.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService {
    //standard,section,role - FK
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private StandardRepository standardRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private StudentQuestionAnswerRepository stuquesansrepository;
	
	
	
	@Autowired
	private EmailService emailService;
	@Override
	public User addUser(UserDao userDao) throws Exception {
		
//		User user = new User();
		User user1 =userRepository.findByUsername(userDao.getUsername());
		
//		String username=userRepository.searchByUsername(userDao.getUsername());
		
		//Long standardId=userDao.getStandard().getStandardId();
		Standard standard=standardRepository.findById(userDao.getStandard().getStandardId()).get();
		Section section=sectionRepository.findById(userDao.getSection().getSectionId()).get();
		//Role role=roleRepository.findById(userDao.getRole().getRoleId()).get();
		Role role=roleRepository.findById(12L).get();
		//username must not be same as admin and password must also be not the same 
		//Role role=roleRepository.findById(userDao.getRole().getRoleId()).get();
		if(user1!=null) {
			throw new Exception("username already exists");
		}
		
		User user=new User();
		//Long sectionId=userDao.getSection().getSectionId();
		user.setUsername(userDao.getUsername());
		user.setPassword(userDao.getPassword());
		user.setEmail(userDao.getEmail());
		user.setFirstname(userDao.getFirstname());
		user.setLastname(userDao.getLastname());
		
		user.setStandard(standard);
		user.setSection(section);
		user.setRole(role);
		
		//section.setStandard(standard);
		this.userRepository.save(user);
		Email email=new Email();
		email.setSubject("Welcome to Exam PORTAL");
        email.setMessage("<h2>Hello " + userDao.getUsername() + ",</h2>"+
                            "<h3>You are Registered for the Exam </h3>" + "<p>Use the given username and password to attempt the quiz</p><br>" 
                            + "<h3>Username: "+userDao.getUsername() + "<br>Password: <b>"+ userDao.getPassword() +"</b></h3>"  );
        email.setTo(userDao.getEmail());
        
        this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
        return user;
        
	}
	@Override
	public User updateUser(UserDao userDao, Long id) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user does not exist"));
		Standard standard=standardRepository.findById(userDao.getStandard().getStandardId()).get();
		Section section=sectionRepository.findById(userDao.getSection().getSectionId()).get();
		Role role=roleRepository.findById(userDao.getRole().getRoleId()).get();
		//User user=new User();
		//Long sectionId=userDao.getSection().getSectionId();
		user.setUsername(userDao.getUsername());
		user.setPassword(userDao.getPassword());
		user.setEmail(userDao.getEmail());
		user.setFirstname(userDao.getFirstname());
		user.setLastname(userDao.getLastname());
		
		user.setStandard(standard);
		user.setSection(section);
		user.setRole(role);
		//section.setStandard(standard);
		return this.userRepository.save(user);
	}
	@Override
	public List<User> getUser() {
		
		return userRepository.findAll();
	}
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id).get();
	}
	
	@Override
	public void deleteUserById(Long id) {
		
		this.userRepository.deleteById(id);
		
	}
//	public void deleteByStandardId(Long standardId) {
//		this.userRepository.deleteByStandardId(standardId);
//	}
	//@SuppressWarnings("unchecked")
	@Override
	public List<User> deleteByStandardId(Long standardId) {
		// TODO Auto-generated method stub
		Standard standard=standardRepository.findById(standardId).get();
		List<User> user=Arrays.asList();
		if(standard!=null) {
			//this is a method made in the userRepository 
			user=userRepository.findByStandard(standard);//passed the standard id to this method and stored in list
			//looping this list of users and deleting each user by Id
			for(int i=0;i<user.size();i++) {
				
//				this.stuquesansrepository.deleteByUser(user.get(i));
				user.get(i).setDeleted(true);
				this.userRepository.save(user.get(i));
				
				
				
			}
			
		}
		return user;
	}
	
	
	public List<User> deleteBySectionId(Long sectionId){
		Section section=sectionRepository.findById(sectionId).get();
		List<User> user=Arrays.asList();
		if(section!=null) {
			//this is a method made in the userRepository 
			user=userRepository.findBySection(section);//passed the standard id to this method and stored in list
			//looping this list of users and deleting each user by Id
			for(int i=0;i<user.size();i++) {
				user.get(i).setDeleted(true);
				this.userRepository.save(user.get(i));
				
			}
			
		}
		return user;
	}
	
	public List<User> findUsersExceptAdmin(){
		List<User> users = userRepository.findUsers();
		return users;
	}
	
	public User findUser(String username){
		User users=userRepository.findByUsername(username);
//		this.userRepository.save(users);
		if(users==null) {
			throw new IllegalArgumentException("no such username exists");
		}
		Email email=new Email();
		email.setSubject("Password details ");
        email.setMessage( "<p>Please find your password as below</p>"+
                             "<br>Password: <b>"+ users.getPassword() +"</b></h3>" 
                           );
        email.setTo(users.getEmail());
        
        this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
        return users;
	}
	@Override
	public String changePass(ChangePassword changepassword) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(changepassword.getUsername());
		String currentPassword=user.getPassword();
		if(!currentPassword.equals(changepassword.getOldpassword())) {
			return "incorrect current password";// if the current password is not the old password of change password then incorrect pass msg is shown
		}
		user.setPassword(changepassword.getNewpassword());
		userRepository.save(user);
		return "Password changed successfully";
		
	}
	
	@Override
	public Long countuser(User user) {
		Long count=userRepository.countuser(user);
		return count;
	}
	
	
	
	
	

	

}

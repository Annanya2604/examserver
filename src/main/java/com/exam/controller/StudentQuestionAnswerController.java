package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.exam.dao.QuestionsDao;
import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.StudentQuizDao;
import com.exam.dao.UserDao;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;
import com.exam.service.StudentQuesAnsService;
import com.exam.service.UserService;


@RestController
@RequestMapping("/studentquestionanswer")
@CrossOrigin("*")
public class StudentQuestionAnswerController {
	
	@Autowired
	private StudentQuesAnsService studentqueansservice;
	
	@PostMapping("/add")
	 public StudentQuestionAnswer addStuqueans(@RequestBody StudentQuestionAnswerDao stuqueansdao)
	 {   

		StudentQuestionAnswer stuqueans= this.studentqueansservice.addStudentAnswer(stuqueansdao);
		 return stuqueans;
	     
	 }
//	@PostMapping("/add")
//	 public List<StudentQuestionAnswer>  addStuquiz(@RequestBody StudentQuizDao studentquizdao)
//	 {   
//		 StudentQuiz stuquiz=this.studentquizservice.addStudentQuiz(studentquizdao);
//		 return ResponseEntity.ok(stuquiz);
//	     
//	 }
	@GetMapping("/get")
	 public List<StudentQuestionAnswer> addStuqueans() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return studentqueansservice.getStudentQueAns();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	 //getting the details of a specific answer
	 @GetMapping("/{qaId}")
	 private StudentQuestionAnswer getanswer(@PathVariable("qaId") Long qaId){
		 return null;
	 }
	 
	 
	 //delete the user by id 
	 @DeleteMapping("/{qaId}")
	 public StudentQuestionAnswer deleteanswer(@PathVariable("qaId") Long qaId) {
		 return null;
	 }
	 
	 @PutMapping("/update/{qaId}")
	 public StudentQuestionAnswer updateanswer(@PathVariable("qaId")Long qaId, @RequestBody StudentQuestionAnswer studentquestionanswer) {
		return null;
		 
	 }
	 
	 
}

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

import com.exam.dao.AnswerDao;
import com.exam.dao.QuestionsDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.service.AnswerService;


@RestController
@RequestMapping("/answer")
@CrossOrigin("*")
public class AnswerController {
	//@PathVariable("answerId") Long answerId
	 @Autowired
	 private AnswerService answerservice;
	 
	@PostMapping("/add")
	 public ResponseEntity<?> addAnswers(@RequestBody AnswerDao answerDao)
	 {   
		 Answer a=this.answerservice.addAnswer(answerDao);
		 return ResponseEntity.ok(a);
	     
	 }
	
	@GetMapping("/get")
	 public List<Answer> getAnswer() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return answerservice.getAnswers();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	
	
	@GetMapping("/get/{optionId}")
	 private Answer getAnswerById(@PathVariable("optionId") Long optionId){
		 return answerservice.getAnswerById(optionId);
	 }
	 
	 
	 
	 
	 
	 //delete the user by id 
	@DeleteMapping("/delete/{optionId}")
	 public ResponseEntity<String> deleteAnswer(@PathVariable("optionId") Long optionId) {
		  answerservice.deleteAnswer(optionId);
		  return new ResponseEntity<String>("Option deleted successfully",HttpStatus.OK);
	 }
	 
	@PutMapping("/update/{optionId}")
	 public ResponseEntity<Answer> updateAnswer(@PathVariable("optionId") Long optionId,@RequestBody AnswerDao answerDao){
		 
		 return new ResponseEntity<Answer>(answerservice.updateAnswer(answerDao,optionId ), HttpStatus.OK);
		 
	 }
	
//	@GetMapping("/getAnswer/{quesId}")
//	 public List<QuestionsDao> getAnswerByQuestion(@PathVariable("quesId") Long quesId) {
//		return answerservice.findByQuestion(quesId);
//		 
//	 }
	 
	 
}

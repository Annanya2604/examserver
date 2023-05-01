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

import com.exam.dao.QuestionsDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.service.QuestionService;

//import com.exam.entity.User;
@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionsController {
	
	@Autowired
	private QuestionService questionservice;
	
	
	 @PostMapping("/add")
	 public QuestionsDao addQuestions(@RequestBody QuestionsDao questionsDao)
	 {   
//		 Questions q=this.questionservice.addQuestion(questionsDao);
		 return this.questionservice.addQuestion(questionsDao);
	     
	 }
	 @GetMapping("/get")
	 public List<Questions> getQuestion() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return questionservice.getQuestions();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	 
	 //getting the details of a specific answer
	 @GetMapping("/get/{quesId}")
	 private QuestionsDao getQuestions(@PathVariable("quesId") Long quesId){
		 return questionservice.getQuestionById(quesId);
	 }
	 
	 //delete the ques by Id 
	 @DeleteMapping("/delete/{quesId}")
	 public ResponseEntity<String> deleteQuestion(@PathVariable("quesId") Long quesId) {
		 questionservice.deleteQuestionsById(quesId);
		 return new ResponseEntity<String>("Question deleted successfully",HttpStatus.OK);
//		  questionservice.deleteQuestionsById(quesId);
//		  return new ResponseEntity<String>("Question deleted successfully",HttpStatus.OK);
	 }
	 
	 @PutMapping("/update/{quesId}")
	 public QuestionsDao updateQuestions(@PathVariable("quesId") Long quesId,@RequestBody QuestionsDao questionsDao,Long optionId){
		 
		 return this.questionservice.updateQuestion(questionsDao, quesId,optionId);
		 
	 }
	 
	 @GetMapping("/getQuestion/{quizId}")
	 public List<QuestionsDao> get(@PathVariable("quizId") Long quizId) {
		return questionservice.findByQuiz(quizId);
		 
	 }
	 
}

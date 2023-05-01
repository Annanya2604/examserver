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

import com.exam.dao.QuizDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.service.QuizService;


@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
     
	@PostMapping("/add")
	 public Quiz addQuiz(@RequestBody QuizDao quizDao)
	 {   
		 Quiz q=this.quizService.addQuiz(quizDao);
		 return q;
	     
	 }
	
	@GetMapping("/get")
	 public List<Quiz> getQuiz() {
//	   
	   return quizService.getQuiz();
	   
		 
	 }
	 
	 //getting the details of a specific quiz 

	@GetMapping("/get/{quizId}")
	 private Quiz getQuiz(@PathVariable("quizId") Long quizId){
		 return quizService.getQuizById(quizId);
	 }

	 
	 //delete the quiz by Id 
//	 @DeleteMapping("/{quizId}")
//	 public Quiz deleteanswer(@PathVariable("quizId") Long quizId) {
//		 return null;
//	 }
	@DeleteMapping("/delete/{quizId}")
	 public ResponseEntity<String> deleteQuiz(@PathVariable("quizId") Long quizId) {
		  quizService.deleteQuiz(quizId);
		  return new ResponseEntity<String>("Quiz deleted successfully",HttpStatus.OK);
	 }
	 
//	 @PutMapping("/update/{quizId}")
//	 public Quiz updateanswer(@PathVariable("quizId")Long quizId, @RequestBody Quiz quiz) {
//		return null;
//		 
//	 }
	@PutMapping("/update/{quizId}")
	 public ResponseEntity<Quiz> updateUser(@PathVariable("quizId") Long quizId,@RequestBody QuizDao quizDao){
		 
		 return new ResponseEntity<Quiz>(quizService.updateQuiz(quizDao, quizId), HttpStatus.OK);
		 
	 }
	
//	@GetMapping("/getQuiz/{subjectId}")
//	 public List<Quiz> getQuizBySubject(@PathVariable("subjectId") Long subjectId) {
//		return quizService.findBySubjectId(subjectId);
//		 
//	 }
	@GetMapping("/getQuiz/{id}")
	 public List<Quiz> getQuizByUser(@PathVariable("id") Long id) {
		return quizService.findByUserId(id);
		 
	 }
	
	@GetMapping("/countquiz")
	 private Long getcountquiz(Quiz quiz) {
		 Long count=quizService.countQuiz(quiz);
		 return count;
	 }
	
	@GetMapping("/countinactive")
	 private Long getcountinactivequiz(Quiz quiz) {
		 Long count=quizService.countQuizbyinactive(quiz);
		 return count;
	 }
	 
	 
}

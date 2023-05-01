package com.exam.controller;


import java.util.List;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.StudentQuizDao;
import com.exam.entity.Answer;
import com.exam.entity.Quiz;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;
import com.exam.repository.StudentQuizRepository;
import com.exam.service.CSVService;
import com.exam.service.StudentQuizService;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;


@RestController
@RequestMapping("/studentquiz")
@CrossOrigin("*")
public class StudentQuizController {
	
	@Autowired
	private StudentQuizService studentquizservice;
	
	@Autowired
	private CSVService fileservice;
	
	@PostMapping("/add")
	 public ResponseEntity<?> addStuquiz(@RequestBody StudentQuizDao studentquizdao)
	 {   
		 StudentQuiz stuquiz=this.studentquizservice.addStudentQuiz(studentquizdao);
		 return ResponseEntity.ok(stuquiz);
	     
	 }
	@GetMapping("/get")
	public List<StudentQuiz> Stuquiz() {
//		   Set<Standard> standards = standardservice.getStandard();
//		   return standards;
		   return studentquizservice.getStudentQuiz();
		   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
			 
		 }
	
//	@GetMapping("/count")
//	private Long getNumberOfUsers(Quiz quiz){
//	    return  studentquizservice.countpassedStudent(quiz);
//	}
	
//	@GetMapping("/count")
//	private Long getNumberOfUsers(Quiz quiz){
//	    return  studentquizservice.countpassedStudent(quiz);
//	}
	
	@GetMapping("/get/{id}/{quizId}")
	 private StudentQuiz getstuquiz(@PathVariable("id") Long id, @PathVariable("quizId") Long quizId){
		 return studentquizservice.findByStuQuizId(id, quizId);
	 }
	
	@GetMapping("/attempt/{id}/{quizId}")
	private StudentQuiz attempt(@PathVariable("id") Long id,@PathVariable("quizId") Long quizId) {
		return studentquizservice.getQuizAttemptedOrNot(id, quizId);
	}
	 
	 //getting the details of a specific answer
	 @GetMapping("/{StudentQuizId}")
	 private StudentQuiz getstudentQuiz(@PathVariable("StudentQuizId") Long StudentQuizId){
		 return null;
	 }
//	 @PostMapping("/add")  // requesting data that is why we use RequestBody annotation
//	 public StudentQuiz createStudentQuiz(@RequestBody StudentQuiz studentQuiz) {
//		return null;
//		 
//	 }
	 
	 //delete the user by id 
	 @DeleteMapping("/{StudentQuizId}")
	 public StudentQuiz deleteStudentQuiz(@PathVariable("StudentQuizId") Long StudentQuizId) {
		 return null;
	 }
	 
	 @PutMapping("/update/{StudentQuizId}")
	 public StudentQuiz updateStudentQuiz(@PathVariable("StudentQuizId")Long StudentQuizId, @RequestBody StudentQuiz studentQuiz) {
		return null;
		 
	 }
	 @GetMapping("/download")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "tutorials.csv";
	    InputStreamResource file = new InputStreamResource(fileservice.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	 
	 @GetMapping("/count")
		private List<StudentQuiz> getNumberOfUsers(StudentQuiz stuquiz){
		    return  studentquizservice.stupass(stuquiz);
		}
	 
	 @GetMapping("/count2")
		private Long getpassstu(StudentQuiz stuquiz){
		    Long count = studentquizservice.pass(stuquiz);
		    return count;
		}
	 
	 @GetMapping("/countfail")
	 private Long getfailstu(StudentQuiz stuquiz) {
		 Long count=studentquizservice.fail(stuquiz);
		 return count;
	 }
	 
}

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

import com.exam.dao.StandardDao;
import com.exam.dao.SubjectDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.service.SubjectService;


@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController {
    
	@Autowired
	private SubjectService subjectservice;
	
//	@Autowired
//	private SubjectDao subjectDao;
//	
	 
	 //getting the details of a specific answer
	 
	 
	 //add  Subject
//	 @PostMapping("/add")  // requesting data that is why we use RequestBody annotation
//	 public ResponseEntity<?> addSubject(@RequestBody Subject subject){
//		Subject subject1=this.subjectservice.addSubject(subject);
//		return ResponseEntity.ok(subject1);
//		 
//	 }
	 
	//getting the details of a specific Subject
	@PostMapping("/add")  // requesting data that is why we use RequestBody annotation
	 public ResponseEntity<?> addSubject(@RequestBody SubjectDao subjectDao){
		Subject sub=this.subjectservice.addSubject(subjectDao);
		return ResponseEntity.ok(sub);
		 
	 }
	 
	 @GetMapping("/get/{subjectId}")
	 private Subject getSubject(@PathVariable("subjectId") Long subjectId){
		 return this.subjectservice.getSubject(subjectId);
	 }
	 
	 @GetMapping("/get")
	 public ResponseEntity<?> getSubject() {
		return ResponseEntity.ok(this.subjectservice.getSubjects());
		 
	 }
	 @PutMapping("/update/{subjectId}")
	 public ResponseEntity<Subject> updateSubject(@PathVariable("subjectId") Long subjectId,@RequestBody SubjectDao subjectDao){
		 
		 return new ResponseEntity<Subject>(subjectservice.updateSubject(subjectDao, subjectId), HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/getSubject/{standardId}")
	 public List<Subject> getSubjectByStandard(@PathVariable("standardId") Long standardId) {
		return subjectservice.findByStandard(standardId);
		 
	 }
	 
	 
	 
	 
	 //update subject 
//	 @PutMapping("/update/{subjectId}")
//	 public Subject updateSubject(@PathVariable("subjectId")Long subjectId, @RequestBody Subject subject) {
//		return this.subjectservice.updateSubject(subject);
//		 
//	 }
	//delete the user by id 
//		 @DeleteMapping("/delete/{subjectId}")
//		 public void deleteSubject(@PathVariable("subjectId") Long subjectId) {
//			  this.subjectservice.deleteSubject(subjectId);
//		 }
	 @DeleteMapping("/delete/{subjectId}")
	 public ResponseEntity<String> deleteSubject(@PathVariable("subjectId") Long subjectId) {
		  this.subjectservice.deleteSubject(subjectId);
		  return new ResponseEntity<String>("Subject deleted successfully",HttpStatus.OK);
	 }
		 
	 
	 
}

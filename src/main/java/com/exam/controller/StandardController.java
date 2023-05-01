package com.exam.controller;

import java.util.List;
import java.util.Set;

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
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.service.StandardService;
import com.exam.service.StandardServiceImpl;


@RestController
@RequestMapping("/standard")
@CrossOrigin("*")
public class StandardController {

	
	@Autowired
	private StandardServiceImpl standardservice;
	
	@PostMapping("/add")  // requesting data that is why we use RequestBody annotation
	 public ResponseEntity<?> addStandard(@RequestBody StandardDao standardDao){
		Standard std=this.standardservice.addStandard(standardDao);
		return ResponseEntity.ok(std);
		 
	 }
	   @GetMapping("/get")
		 public List<Standard> getStandard() {
//		   Set<Standard> standards = standardservice.getStandard();
//		   return standards;
		   return standardservice.getStandard();
		   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
			 
		 }
		 
		 //getting the details of a specific answer
		 @GetMapping("/get/{standardId}")
		 private Standard getstandard(@PathVariable("standardId") Long standardId){
			 return standardservice.getStandardById(standardId);
		 }

		 
		 //delete the user by id 
		 @DeleteMapping("/delete/{standardId}")
		 public void deleteStandard(@PathVariable("standardId") Long standardId) {
			  standardservice.deleteStandardById(standardId);
//			  return new ResponseEntity<String>("Standard deleted successfully",HttpStatus.OK);
		 }
		 

		 
		 @PutMapping("/update/{standardId}")
		 public ResponseEntity<Standard> updateStandard(@PathVariable("standardId") Long standardId,@RequestBody StandardDao standardDao){
			 
			 return new ResponseEntity<Standard>(standardservice.updateStandard(standardDao, standardId), HttpStatus.OK);
			 
		 }
		 
		 @GetMapping("/countstandard")
		 private Long getcountstd(Standard std) {
			 Long count=standardservice.countStandard(std);
			 return count;
		 }
		 
		 

	
	 
	
}

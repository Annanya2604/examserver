package com.exam.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Answer;
import com.exam.entity.Result;


@RestController
@RequestMapping("/result")
public class ResultController {
	//@PathVariable("answerId") Long answerId
	 
		 @GetMapping("/")
		 public Result getResult() {
			return null;
			 
		 }
		 
		 //getting the details of a specific answer
		 @GetMapping("/{resultId}")
		 private Answer getresult(@PathVariable("resultId") Long resultId){
			 return null;
		 }
		 @PostMapping("/add")  // requesting data that is why we use RequestBody annotation
		 public Answer createresult(@RequestBody Result result) {
			return null;
			 
		 }
		 
		 //delete the user by id 
		 @DeleteMapping("/{resultId}")
		 public Answer deleteanswer(@PathVariable("resultId") Long resultId) {
			 return null;
		 }
		 
		 @PutMapping("/update/{resultId}")
		 public Answer updateanswer(@PathVariable("resultId")Long resultId, @RequestBody Result result) {
			return null;
			 
		 }
		 
}

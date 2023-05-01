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

import com.exam.dao.SectionDao;
import com.exam.dao.StandardDao;
import com.exam.entity.Answer;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.service.SectionService;


@RestController
@RequestMapping("/section")
@CrossOrigin("*")
public class SectionController {
	
	@Autowired
	private SectionService sectionservice;
	
	@GetMapping("/get")
	 public List<Section> getSection() {
		return sectionservice.getSection();
		 
	 }
	 
	 //getting the details of a specific answer
	 @GetMapping("/get/{SectionId}")
	 private Section getSection(@PathVariable("SectionId") Long sectionId){
		 return sectionservice.getSectionById(sectionId);
	 }
//	 @PostMapping("/add")  // requesting data that is why we use RequestBody annotation
//	 public ResponseEntity<?> addSection(@RequestBody Section section){
//		Section sec=this.sectionservice.addSection(section);
//		return ResponseEntity.ok(sec);
//		 
//	 }
	 
	 @PostMapping("/add")
	 public ResponseEntity<?> addSection(@RequestBody SectionDao sectionDao)
	 {   
		 Section sec=this.sectionservice.addSection(sectionDao);
		 return ResponseEntity.ok(sec);
	     
	 }
	 //delete the user by id 
	 @DeleteMapping("/delete/{sectionId}")
	 public ResponseEntity<String> deleteStandard(@PathVariable("sectionId") Long sectionId) {
		  sectionservice.deleteSectionById(sectionId);
		  return new ResponseEntity<String>("Section deleted successfully",HttpStatus.OK);
	 }
	 
	 @PutMapping("/update/{sectionId}")
	 public ResponseEntity<Section> updateSection(@PathVariable("sectionId") Long sectionId ,@RequestBody SectionDao sectionDao){
		 
		 return new ResponseEntity<Section>(sectionservice.updateSection(sectionDao, sectionId), HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/getSection/{standardId}")
	 public List<Section> getSectionByStandard(@PathVariable("standardId") Long standardId) {
		return sectionservice.findByStandard(standardId);
		 
	 }
	 
	 
	 
	 
	 
}

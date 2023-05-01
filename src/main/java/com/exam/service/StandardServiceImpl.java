package com.exam.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.dao.StandardDao;
import com.exam.entity.Standard;
import com.exam.entity.User;
import com.exam.repository.SectionRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.UserRepository;
import com.exam.exception.ResourceNotFoundException;
import com.exam.entity.Standard;





@Service
public class StandardServiceImpl implements StandardService{
	@Autowired
	private StandardRepository standardRepository;
	
	@Autowired
	private UserServiceImpl userservice;
	
	@Autowired
	private SectionServiceImpl sectionservice;
	
	@Autowired
	private SubjectServiceImpl subjectservice;
	
	@Autowired
	private QuizServiceImpl quizservice;

	@Override
	public Standard addStandard(StandardDao standardDao) {
		// TODO Auto-generated method stub
		Standard existingstandard=this.standardRepository.findBystandardName(standardDao.getStandardName());
		if(existingstandard !=null && existingstandard.getIsDeleted()== false) {
			throw new IllegalArgumentException("Standard with the same name already exists");
		}
		Standard standard=new Standard();
		standard.setStandardName(standardDao.getStandardName());
		standard.setDescription(standardDao.getDescription());
		return this.standardRepository.save(standard);
	}

	@Override
	public Standard updateStandard(StandardDao standardDao,Long standardId) {
		Standard standard=standardRepository.findById(standardId).orElseThrow(()->new ResourceNotFoundException("standard does not exist"));
		standard.setStandardName(standardDao.getStandardName());
		standard.setDescription(standardDao.getDescription());
		
		//save this employee object to the database
		Standard updatedStandard=standardRepository.save(standard);
		return updatedStandard;
		
		
		
	}

	@Override
	public List<Standard> getStandard() {
		// TODO Auto-generated method stub
		return standardRepository.findByIsDeleted();
	}

	@Override
	public Standard getStandardById(Long standardId) {
		// TODO Auto-generated method stub
		return this.standardRepository.findById(standardId).get(); // this is optional 
	}

	@Override
	public void deleteStandardById(Long standardId) {
		// TODO Auto-generated method stub
		Standard standard = this.standardRepository.findById(standardId).get();
		this.userservice.deleteByStandardId(standardId);
		this.quizservice.deleteByStandardId(standardId);
		this.subjectservice.deleteByStandardId(standardId);
		this.sectionservice.deleteByStandardId(standardId);
		standard.setIsDeleted(true);
		this.standardRepository.save(standard);
		
		
		
		
		
		//public List<User> deleteByStandardId(Long standardId);
//		this.standardRepository.deleteById(standardId);//deletes employee from the database with a given id 
		//this.standardRepository.delete();
	}
	
	@Override
	public Long countStandard(Standard standard) {
		Long count=standardRepository.countStandard(standard);
		return count;
	}
	

}

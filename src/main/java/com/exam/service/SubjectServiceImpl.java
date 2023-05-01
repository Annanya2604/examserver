package com.exam.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.SubjectDao;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.SectionRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.SubjectRepository;


@Service
public class SubjectServiceImpl implements SubjectService {
    
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StandardRepository standardRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	@Override
	public Subject addSubject(SubjectDao subjectDao) {
		String subjectName = subjectDao.getSubjectName();
		Standard standard1 = this.standardRepository.findById(subjectDao.getStandard().getStandardId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid standard id"));
		Subject existingsubject = subjectRepository.findBySubjectNameAndStandard(subjectName, standard1);
		if(existingsubject!=null) {
			throw new IllegalArgumentException("Subject with the same name already exists");
		}
		Subject subject=new Subject();
		subject.setSubjectName(subjectDao.getSubjectName());
		Standard standard=standardRepository.findById(subjectDao.getStandard().getStandardId()).get();
		//Section section=sectionRepository.findById(subjectDao.getSection().getSectionId()).get();
		subject.setSubjectName(subjectDao.getSubjectName());
		
		subject.setStandard(standard);
		// TODO Auto-generated method stub
		return this.subjectRepository.save(subject);
	}

	@Override
	public Subject updateSubject(SubjectDao subjectDao,Long subjectId) {
		// TODO Auto-generated method stub
		Subject sub=subjectRepository.findById(subjectId).orElseThrow(()->new ResourceNotFoundException("subject does not exist"));
		Standard standard=standardRepository.findById(subjectDao.getStandard().getStandardId()).get();
		//Section section=sectionRepository.findById(subjectDao.getSection().getSectionId()).get();
		sub.setSubjectName(subjectDao.getSubjectName());
		//sub.setSection(section);
		sub.setStandard(standard);
		
		return this.subjectRepository.save(sub);
	}

	@Override
	public List<Subject> getSubjects() {
		// TODO Auto-generated method stub
		//return new LinkedHashSet<>(this.subjectRepository.findAll());
		return subjectRepository.findByIsDeleted();
//		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubject(Long subjectId) {
		// TODO Auto-generated method stub
		return this.subjectRepository.findById(subjectId).get();
	}

	@Override
	public void deleteSubject(Long subjectId) {
		// TODO Auto-generated method stub
		Subject sub = subjectRepository.findById(subjectId).get();
		sub.setIsDeleted(true);
		this.subjectRepository.save(sub);
	}
	
	@Override
	public List<Subject> findByStandard(Long standardId) {

		// List<Section>
		// sectionlist=sectionRepository.findByStandardId(standard.getStandardId());
		List<Subject> subjectlist = subjectRepository.findByStandardId(standardId);

		// section.forEach(this.sectionRepository.findById(section.get.getSectionId()));

		return subjectlist;

	}
	public List<Subject> deleteByStandardId(Long standardId) {
		// TODO Auto-generated method stub
		Standard standard=standardRepository.findById(standardId).get();
		List<Subject> subject=new ArrayList<Subject>();
		if(standard!=null) {
			//this is a method made in the userRepository 
			subject=subjectRepository.findByStandardId(standardId);//passed the standard id to this method and stored in list
			//looping this list of users and deleting each user by Id
			for(int i=0;i<subject.size();i++) {
				subject.get(i).setIsDeleted(true);
				this.subjectRepository.save(subject.get(i));
			} 
			
		}
		return subject;
	}

}

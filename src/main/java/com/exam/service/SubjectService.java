package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.dao.SubjectDao;
import com.exam.dao.UserDao;
import com.exam.entity.Section;

//import org.springframework.stereotype.Service;

import com.exam.entity.Subject;
import com.exam.entity.User;


public interface SubjectService {

	public Subject addSubject(SubjectDao subjectdao);
	public List<Subject> getSubjects();
	
	public Subject getSubject(Long subjectId);
	public void deleteSubject(Long subjectId);
	public Subject updateSubject(SubjectDao subjectDao,Long subjectId);
	public List<Subject> findByStandard(Long standardId);
	
	
}

package com.exam.service;

import java.io.ByteArrayInputStream;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Helper.helper;
import com.exam.entity.StudentQuiz;
import com.exam.repository.StudentQuizRepository;


@Service
public class CSVService {
	
	@Autowired
	private StudentQuizRepository stuquizrepo;
	public ByteArrayInputStream load() {
	    List<StudentQuiz> tutorials = stuquizrepo.findAll();

	    ByteArrayInputStream in = helper.tutorialsToCSV(tutorials);
	    return in;
	  }

}

package com.exam.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.StudentQuizDao;
import com.exam.entity.Quiz;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;


public interface StudentQuizService {
	public StudentQuiz addStudentQuiz(StudentQuizDao studentquizdao);
	public List<StudentQuiz> getStudentQuiz();
	public StudentQuiz findByStuQuizId(Long id,Long quizId);
	public StudentQuiz  getQuizAttemptedOrNot(Long studentId, Long quizId);
//	public Long countpassedStudent(Quiz quiz);
	public List<StudentQuiz> stupass(StudentQuiz stuquiz);
	public Long pass(StudentQuiz stuquiz);
	public Long fail(StudentQuiz stuquiz);
	
	
}

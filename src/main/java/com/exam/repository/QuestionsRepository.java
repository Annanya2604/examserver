package com.exam.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.dao.QuestionsDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Standard;
import com.exam.entity.User;

public interface QuestionsRepository  extends JpaRepository<Questions,Long>{

	List<Questions> findByQuiz(Quiz quiz);
//	public List<Questions> deleteByQuiz(Quiz quiz);
	
	
//	@Query(value = "SELECT q FROM Questions q WHERE q.quiz.quizId = :quizId")
//	public List<Questions> findByQuizId(Long quizId);
	
//	public List<Questions> findByQuizId(Quiz quiz);
	
	
	

}

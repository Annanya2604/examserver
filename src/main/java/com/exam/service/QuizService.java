package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.dao.QuizDao;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.StudentQuiz;

public interface QuizService {
   public Quiz addQuiz(QuizDao quizdao);
   
   public Quiz updateQuiz(QuizDao quizdao, Long quizId);
   
   public List<Quiz> getQuiz();
   
   public Quiz getQuizById(Long quizId);
   
   public void deleteQuiz(Long quizId); 
   public List<Quiz> findByUserId(Long id);
   public List<Quiz> deleteByStandardId(Long standardId);
   public Long countQuiz(Quiz quiz);
   public Long countQuizbyinactive(Quiz quiz);
   public void deleteQuizById(Long QuizId);
}
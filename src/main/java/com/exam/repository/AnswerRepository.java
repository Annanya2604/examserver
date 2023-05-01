package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.Subject;
import com.exam.entity.User;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{
	@Query(value = "SELECT a FROM Answer a WHERE a.question.quesId = :quesId")
	public List<Answer> findByQuestionId(Long quesId);
	
	public List<Answer> findByQuestion(Questions question);
	
	@Query(value = "SELECT a FROM Answer a WHERE a.optionId = :optionId")
	void deleteAnswerById(Long optionId);
//	public List<Answer> deleteByQuiz(Quiz quiz);
	
}

package com.exam.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.User;

public interface StudentQuestionAnswerRepository extends JpaRepository<StudentQuestionAnswer,Long>{ 
	
	@Query(value = "SELECT SUM(s.quesMarks) FROM StudentQuestionAnswer s WHERE s.user.id=:id AND s.question.quiz.quizId=:quizId ")
	public Long findtotalByUser(Long id,Long quizId);
	
	public List<StudentQuestionAnswer> deleteByUser(User user);
}

//SELECT id,SUM(quesMarks) FROM StudentQuestionAnswer WHERE StudentQuestionAnswer.id=StudentQuiz.id GROUP BY :id 
package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Section;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;

public interface StudentQuizRepository extends JpaRepository<StudentQuiz,Long> {

	@Query(value = "SELECT s FROM StudentQuiz s WHERE s.user.id = :id AND s.quiz.quizId =:quizId")
	public StudentQuiz findByStuQuizId(Long id,Long quizId);
	
	@Query(value="SELECT q FROM StudentQuiz q WHERE q.resultStatus='Pass'")
	public List<StudentQuiz> studentpassed(String resultStatus);
	
	@Query(value="SELECT COUNT(q) FROM StudentQuiz q WHERE q.resultStatus='Pass'")
	public Long studentpass(String resultStatus);
	
	@Query(value="SELECT COUNT(q) FROM StudentQuiz q WHERE q.resultStatus = 'Fail'")
	public Long studentfail(String resultStatus);
	
	
}

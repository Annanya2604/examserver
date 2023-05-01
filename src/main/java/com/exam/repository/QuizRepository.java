package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;

public interface QuizRepository extends JpaRepository<Quiz,Long>{
	@Query(value = "SELECT q FROM Questions q WHERE q.quiz.quizId = :quizId")
	public List<Questions> findByQuizId(Long quizId);
	
	@Query(value = "SELECT q FROM Quiz q WHERE q.subject.subjectId = :subjectId")
	public List<Quiz> findBySubjectId(Long subjectId);
	
	@Query(value="SELECT q FROM Quiz q WHERE q.subject IN (:subject)")
	public List<Quiz> findBySubject(List<Subject> subject);
	
	@Query(value="SELECT q FROM Quiz q WHERE q.subject.standard = :standard")
	public List<Quiz> findByStandard(Standard standard);
	
	@Query(value="SELECT COUNT(q) FROM Quiz q WHERE q.isActive='true' ")
	public Long countQuiz(Quiz quiz);
	
	@Query(value="SELECT COUNT(q) FROM Quiz q WHERE q.isActive='false' ")
	public Long countQuizinactive(Quiz quiz);
	
	
	
	
}

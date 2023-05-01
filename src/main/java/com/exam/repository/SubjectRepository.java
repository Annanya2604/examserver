package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
	@Query(value = "SELECT s FROM Subject s WHERE s.standard.standardId = :standardId")
	public List<Subject> findByStandardId(Long standardId);
	
	@Query(value= "SELECT s FROM Subject s WHERE  s.subjectName = :subjectName AND s.standard =:standard ")
	public 	Subject findBySubjectNameAndStandard(String subjectName, Standard standard);
	
	@Query(value="SELECT s FROM Subject s WHERE s.isDeleted = false")
	public List<Subject> findByIsDeleted();
	
}

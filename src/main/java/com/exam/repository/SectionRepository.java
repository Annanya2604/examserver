package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.User;

public interface SectionRepository extends JpaRepository<Section,Long>{
	//public void deleteByStandardId(Long standardId);
	public List<Section> findByStandard(Standard standard);
	
	@Query(value = "SELECT s FROM Section s WHERE s.standard.standardId = :standardId")
	public List<Section> findByStandardId(Long standardId);
	
	@Query(value= "SELECT s FROM Section s WHERE  s.sectionName = :sectionName AND s.standard.standardName =:standardName ")
	public Section findBysectionName(String sectionName,String standardName);
	
	@Query(value= "SELECT s FROM Section s WHERE  s.sectionName = :sectionName AND s.standard =:standard ")
	public Section findBySectionNameAndStandard(String sectionName, Standard standard);
	
	@Query(value="SELECT s FROM Section s WHERE s.isDeleted=false")
	public List<Section> findByIsDeleted();
	
}

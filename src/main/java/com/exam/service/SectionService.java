package com.exam.service;

import java.util.List;

import com.exam.dao.SectionDao;
import com.exam.dao.StandardDao;
import com.exam.entity.Section;
import com.exam.entity.Standard;

//interface is a class with abstract methods so we create another class to implement the interface
public interface SectionService {
	//public Section addSection(Section section);
	public Section addSection(SectionDao sectionDao);
	public Section updateSection(SectionDao sectionDao,Long sectionId);
	public List<Section> getSection();
	public Section getSectionById(Long sectionId);
	public void deleteSectionById(Long sectionId);
//	public void deleteByStandardId(Long standardId);
	public List<Section> deleteByStandardId(Long standardId);
	//public List<Section> findByStandardId(Long StandardId);
	public List<Section> findByStandard(Long standardId);
}

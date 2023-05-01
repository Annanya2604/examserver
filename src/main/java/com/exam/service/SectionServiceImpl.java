package com.exam.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.SectionDao;
import com.exam.dao.StandardDao;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.SectionRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.UserRepository;

@Service
public class SectionServiceImpl implements SectionService {
	@Autowired
	private StandardRepository standardRepository;

	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private UserService userservice;
	// @Override
//	public Section addSection(Section section) {
//		
////		Long standardId=section.getStandard().getStandardId();// the method of the S
////		Standard standard=standardRepository.findById(standardId).get();
////		
////		Section section=new Section();
////		
////		//section name and standard
////		section.setSectionName(section.getSectionName());
////		section.setStandard(standard);
//		return this.sectionRepository.save(section);
//	}

	@Override
	public Section addSection(SectionDao sectionDao) {
		// TODO Auto-generated method stub
		String sectionName = sectionDao.getSectionName();
		Standard standard1 = standardRepository.findById(sectionDao.getStandard().getStandardId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid standard id"));
//		Section existingsection=this.sectionRepository.findBysectionName(sectionDao.getSectionName(),sectionDao.getStandard().getStandardName());
		Section existingsection = sectionRepository.findBySectionNameAndStandard(sectionName, standard1);
		if(existingsection !=null ) {
			throw new IllegalArgumentException("Section with the same name already exists");
		}
		Long standardId = sectionDao.getStandard().getStandardId();
		Standard standard = standardRepository.findById(standardId).get();
		Section section = new Section();
		section.setSectionName(sectionDao.getSectionName());
		section.setStandard(standard);
		return this.sectionRepository.save(section);
	}

	@Override
	public Section updateSection(SectionDao sectionDao, Long sectionId) {
		// TODO Auto-generated method stub
		Long standardId = sectionDao.getStandard().getStandardId();
		Standard standard = standardRepository.findById(standardId).get();
		Section section = sectionRepository.findById(sectionId)
				.orElseThrow(() -> new ResourceNotFoundException("section does not exist"));
		section.setSectionName(sectionDao.getSectionName());
		section.setStandard(standard);

		// save this employee object to the database
		return this.sectionRepository.save(section);

	}

	@Override
	public List<Section> getSection() {
		// TODO Auto-generated method stub
		return this.sectionRepository.findByIsDeleted();
//		return (List<Section>) sectionRepository.findAll();
	}

	@Override
	public Section getSectionById(Long sectionId) {
		// TODO Auto-generated method stub
		return this.sectionRepository.findById(sectionId).get();
	}

	@Override
	public void deleteSectionById(Long sectionId) {
		Section section =this.sectionRepository.findById(sectionId).get();
		this.userservice.deleteBySectionId(sectionId);
		section.setIsDeleted(true);
		this.sectionRepository.save(section);

	}

//	public void deleteByStandardId(Long standardId) {
//		this.sectionRepository.deleteByStandardId(standardId);
//	}
	@Override
	public List<Section> deleteByStandardId(Long standardId) {
		// TODO Auto-generated method stub
		Standard standard = standardRepository.findById(standardId).get();
		List<Section> section = Arrays.asList();
		if (standard != null) {
			section = sectionRepository.findByStandard(standard);
			for (int i = 0; i < section.size(); i++) {
				section.get(i).setIsDeleted(true);
				this.sectionRepository.save(section.get(i));
			}

		}
		return section;
	}

	public List<Section> findByStandard(Long standardId) {

		// List<Section>
		// sectionlist=sectionRepository.findByStandardId(standard.getStandardId());
		List<Section> sectionlist = sectionRepository.findByStandardId(standardId);

		// section.forEach(this.sectionRepository.findById(section.get.getSectionId()));

		return sectionlist;

	}

}

package com.exam.dao;



public class SectionDao {
	private Long sectionId;
	
	private String sectionName;
//	
//	private StandardDao standardId;

	
	private StandardDao standard;
	
	
	
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
//	public StandardDao getStandardId() {
//		return standardId;
//	}
//	public void setStandardId(StandardDao standardId) {
//		this.standardId = standardId;
//	}
	public StandardDao getStandard() {
		return standard;
	}
	public void setStandard(StandardDao standard) {
		this.standard = standard;
	}
	

	
}

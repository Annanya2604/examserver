package com.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private Long subjectId;//PK
	
	@Column(name="subject_name")
	private String subjectName;
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Standard standard;

	@Column(name = "isDeleted")
	  private Boolean isDeleted =false;
	
	
//	@ManyToOne
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Section section;
//	@Column(name="section_id") //FK
//	private Long sectionId;
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public Subject() {
		
	}

	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public Standard getStandard() {
		return standard;
	}


	public void setStandard(Standard standard) {
		this.standard = standard;
	}


//	public Section getSection() {
//		return section;
//	}
//
//
//	public void setSection(Section section) {
//		this.section = section;
//	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	

	
}

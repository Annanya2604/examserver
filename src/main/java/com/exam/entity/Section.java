package com.exam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="section")
public class Section {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) //PK
	 private Long sectionId;
	
	 @Column(name="section_name")
	 private String sectionName;
	
	 @Column(name = "isDeleted")
	  private Boolean isDeleted =false;
	 
	 public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@ManyToOne
	 //@OnDelete(action = OnDeleteAction.CASCADE)
	 //@JoinColumn(name="standard_id")
	 //@OnDelete(action = OnDeleteAction.CASCADE)
	  private Standard standard;
	 
	 
	
	public Section() {
		
	}

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

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}



	

	

	

	
	
}

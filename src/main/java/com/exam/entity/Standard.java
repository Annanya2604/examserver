package com.exam.entity;

//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="standard")
public class Standard {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //PK
	private Long standardId;
	
	@Column(name="standard_name")
    private String standardName;
    
	@Column(name="description")
    private String description;
	
	@Column(name = "isDeleted")
    private Boolean isDeleted =false;
	
//	@OneToMany(mappedBy="standard")
//	private Set<Section> section;
    
    public Standard() {
    	
    }

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getStandardId() {
		return standardId;
	}

	public void setStandardId(Long standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
    
    
	
}

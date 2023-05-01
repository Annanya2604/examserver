package com.exam.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name="quiz")
public class Quiz {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//auto increment
    private Long quizId; //PK
  
  
  private String quizName;
  
  
  
  private Timestamp startTime;
  
  private Timestamp endTime;
  
  private Long quizMarks;
  
  
  
  private Long noOfQues;
  
  private String description;
  
  private Boolean isActive;
  
  private Timestamp createdDate;
  
  private Timestamp updatedDate;
  //fetch type -LAZY -unnecessary details not fetched ,EAGER -all details fetched 
  
  //@JoinColumn(name="subject_id")//composite key - to uniquely identify
  @ManyToOne
  //@OnDelete(action = OnDeleteAction.CASCADE)
  private Subject subject;// FK
  
  
  private Long passingMarks; 
  
  @Column(name = "isDeleted")
  private Boolean isDeleted =false;
  
  public Boolean getIsDeleted() {
	return isDeleted;
}


public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
}


public Quiz() {
	  
  }


public Long getQuizId() {
	return quizId;
}




public void setQuizId(Long quizId) {
	this.quizId = quizId;
}



public String getQuizName() {
	return quizName;
}

public void setQuizName(String quizName) {
	this.quizName = quizName;
}





public Timestamp getStartTime() {
	return startTime;
}


public void setStartTime(Timestamp startTime) {
	this.startTime = startTime;
}


public Timestamp getCreatedDate() {
	return createdDate;
}


public void setCreatedDate(Timestamp createdDate) {
	this.createdDate = createdDate;
}


public Timestamp getUpdatedDate() {
	return updatedDate;
}


public void setUpdatedDate(Timestamp updatedDate) {
	this.updatedDate = updatedDate;
}


public Timestamp getEndTime() {
	return endTime;
}


public void setEndTime(Timestamp timestamp) {
	this.endTime = timestamp;
}

public Long getQuizMarks() {
	return quizMarks;
}

public void setQuizMarks(Long quizMarks) {
	this.quizMarks = quizMarks;
}

public Long getNoOfQues() {
	return noOfQues;
}

public void setNoOfQues(Long noOfQues) {
	this.noOfQues = noOfQues;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}





public Subject getSubject() {
	return subject;
}






public void setSubject(Subject subject) {
	this.subject = subject;
}






public Long getPassingMarks() {
	return passingMarks;
}

public void setPassingMarks(Long passingMarks) {
	this.passingMarks = passingMarks;
}






  
}

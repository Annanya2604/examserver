package com.exam.dao;

import java.sql.Date;
import java.sql.Timestamp;



public class QuizDao {
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
	  
	  
	  private SubjectDao subject;// FK
	  
	  
	  private Long passingMarks; 
	  
	  public QuizDao() {
		  
	  }

	

	public Long getQuizId() {
		return quizId;
	}



	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}





	public SubjectDao getSubject() {
		return subject;
	}



	public void setSubject(SubjectDao subject) {
		this.subject = subject;
	}



	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	

	

	public Timestamp getCreatedDate() {
		return createdDate;
	}



	public Timestamp getUpdatedDate() {
		return updatedDate;
	}



	public Timestamp getStartTime() {
		return startTime;
	}



	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}



	public Timestamp getEndTime() {
		return endTime;
	}



	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}



	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}



	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
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

	public Long getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(Long passingMarks) {
		this.passingMarks = passingMarks;
	}

	  



}

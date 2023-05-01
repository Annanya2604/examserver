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
@Table(name="result")
public class Result {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long resultId; //PK
	
	@ManyToOne(targetEntity=Quiz.class)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Quiz quiz; //FK 
	
	@Column(name="id")
	private Long id;
	
	@Column(name="marks_obtained")
	private Long marksObtained;
	
	@Column(name="result_status")
	private Long resultStatus;
	
	@Column(name = "isDeleted")
	  private Boolean isDeleted =false;
	
	public Result() {
		
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Long marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Long getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Long resultStatus) {
		this.resultStatus = resultStatus;
	}


	
	

}

package com.exam.entity;

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
@Table(name="questions")
public class Questions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long quesId; //PK
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JoinColumn(name="quiz_id")
     private Quiz quiz; //FK
	
	@Column(name="ques_marks")
	private Long quesMarks;
	
	


	@Column(name="ques_name")
	private String quesName;
	
	@Column(name = "isDeleted")
	  private Boolean isDeleted =false;
	
	
	public Questions() {
		
	}


	public Long getQuesId() {
		return quesId;
	}


	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public Long getQuesMarks() {
		return quesMarks;
	}


	public void setQuesMarks(Long quesMarks) {
		this.quesMarks = quesMarks;
	}


	public String getQuesName() {
		return quesName;
	}


	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	

	
	


	




	

	
}

package com.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="answer") //options table 
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long optionId; //PK
	  
	



	//@OneToOne
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Questions question;//FK
//	@Column(name="ques_id")
//     private Long quesId; //FK

	@Column(name="option_name")
     private String optionName;
     
	@Column(name="isCorrect")
     private Boolean isCorrect;
	
	@Column(name = "isDeleted")
	  private Boolean isDeleted =false;
	
	public Questions getQuestion() {
		return question;
	}




	public void setQuestion(Questions question) {
		this.question = question;
	}
     
     public Answer() {
    	 
     }
     
   


	public Long getOptionId() {
		return optionId;
	}



	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}



	



	public String getOptionName() {
		return optionName;
	}



	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}



	public Boolean getIsCorrect() {
		return isCorrect;
	}



	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}




	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}



	
     
    
}

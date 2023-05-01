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
@Table(name="student_question_answer")
public class StudentQuestionAnswer {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
      private Long qaId;
      
      @ManyToOne
     // @OnDelete(action = OnDeleteAction.CASCADE)
      private User user;
     // private Long id;//FK
      
      @ManyToOne
     // @OnDelete(action = OnDeleteAction.CASCADE)
      private Questions question;
      //private long quesId;//FK
      
      @Column(name="ques_marks")
  	  private Long quesMarks;
      
      @ManyToOne
     // @OnDelete(action = OnDeleteAction.CASCADE)
      private Answer answer;
      //private long OptionId;//FK
      @Column(name = "isDeleted")
      private Boolean isDeleted =false;
      
      public StudentQuestionAnswer() {
  		
  	}
  	

	public Long getQuesMarks() {
		return quesMarks;
	}


	public void setQuesMarks(Long quesMarks) {
		this.quesMarks = quesMarks;
	}


	public Long getQaId() {
		return qaId;
	}

	public void setQaId(Long qaId) {
		this.qaId = qaId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Questions getQuestion() {
		return question;
	}


	public void setQuestion(Questions question) {
		this.question = question;
	}


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	
}

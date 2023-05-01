package com.exam.entity;

import java.sql.Date;

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
@Table(name="studentQuiz")
public class StudentQuiz {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long StudentQuizId;
    
    private Date startTime;
    
    private Date endTime;
    
    private Long attemptedques;
    
    @Column(name = "isDeleted")
    private Boolean isDeleted =false;
    
    public Long getAttemptedques() {
		return attemptedques;
	}

	public void setAttemptedques(Long attemptedques) {
		this.attemptedques = attemptedques;
	}

	private Long correctAnswer;
    
    @Column(name="marks_obtained")
	private Long marksObtained;
    
    @Column(name="result_status")
	private String resultStatus;
    
    @ManyToOne 
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quiz quiz;
    
    public StudentQuiz() {
    	
    }

	public Long getStudentQuizId() {
		return StudentQuizId;
	}

	public void setStudentQuizId(Long studentQuizId) {
		StudentQuizId = studentQuizId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	

	

	public Long getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Long correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	

	public Long getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Long marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	

	
}

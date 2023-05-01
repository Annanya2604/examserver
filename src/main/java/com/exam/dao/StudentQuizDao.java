package com.exam.dao;

import java.sql.Date;

public class StudentQuizDao {
	private Long StudentQuizId;

	private Date startTime;

	private Date endTime;

	private Long attemptedques;

	private Long correctAnswer;

	private UserDao user;

	private QuizDao quiz;

	private Long marksObtained;

	private String resultStatus;

	public StudentQuizDao() {

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

	public Long getAttemptedques() {
		return attemptedques;
	}

	public void setAttemptedques(Long attemptedques) {
		this.attemptedques = attemptedques;
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

	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}

	public QuizDao getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizDao quiz) {
		this.quiz = quiz;
	}

}

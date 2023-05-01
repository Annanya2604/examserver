package com.exam.dao;



public class ResultDao {
private Long resultId; //PK
	
	
	private QuizDao quizId; //FK 
	
	
	private Long id;
	
	
	private Long marksObtained;
	
	
	private Long resultStatus;
	
	public ResultDao() {
		
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public QuizDao getQuizId() {
		return quizId;
	}

	public void setQuizId(QuizDao quizId) {
		this.quizId = quizId;
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

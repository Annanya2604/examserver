package com.exam.dao;

import java.util.List;

public class QuestionsDao {
      private Long quesId; //PK
	
	
	
     private QuizDao quiz; //FK
	
	
	private Long quesMarks;
	private String quesName;
	private List<AnswerDao> answer;
	
	
	public List<AnswerDao> getAnswer() {
		return answer;
	}





	public void setAnswer(List<AnswerDao> answer) {
		this.answer = answer;
	}





	public QuestionsDao(List<AnswerDao> answer) {
		super();
		this.answer = answer;
	}


	
 	
	
	public QuestionsDao() {
		
	}


	


	public Long getQuesId() {
		return quesId;
	}





	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}





	public QuizDao getQuiz() {
		return quiz;
	}


	public void setQuiz(QuizDao quiz) {
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


	


	
	
	


}

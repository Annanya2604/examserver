package com.exam.dao;



public class AnswerDao {
	private Long optionId; //PK
	  
	
	private QuestionsDao question;//FK

     
	
     private String optionName;
     
	
     private Boolean isCorrect;
     
     public AnswerDao() {
    	 
     }
 //get allstudentsById
	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	

	public QuestionsDao getQuestion() {
		return question;
	}
	public void setQuestion(QuestionsDao question) {
		this.question = question;
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
     
   


	
}

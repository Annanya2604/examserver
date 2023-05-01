package com.exam.dao;

import java.util.List;

public class StudentQuestionAnswerDao {
	private Long qaId;
    
    
    private UserDao user;
   // private Long id;//FK
    
    private List<Long> quesMarks;
    
    
    private List<QuestionsDao> ques;
    //private long quesId;//FK
    
    
    private List<AnswerDao> answer;
    //private long OptionId;//FK
    
    

	public StudentQuestionAnswerDao() {
		
	}

	public Long getQaId() {
		return qaId;
	}

	public void setQaId(Long qaId) {
		this.qaId = qaId;
	}

	

	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}


	

	public List<Long> getQuesMarks() {
		return quesMarks;
	}

	public void setQuesMarks(List<Long> quesMarks) {
		this.quesMarks = quesMarks;
	}

	public List<QuestionsDao> getQues() {
		return ques;
	}

	public void setQues(List<QuestionsDao> ques) {
		this.ques = ques;
	}

	public List<AnswerDao> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerDao> answer) {
		this.answer = answer;
	}

	
	

	
	
	

	
}

package com.exam.service;

import java.util.List;

import com.exam.dao.AnswerDao;
import com.exam.dao.QuestionsDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.User;


public interface AnswerService {
	public Answer addAnswer(AnswerDao answerdao);
	public List<Answer> getAnswers();
	
	public Answer getAnswerById(Long optionId);
	public void deleteAnswer(Long optionId);
	public Answer updateAnswer(AnswerDao answerdao,Long optionId);
	//public List<QuestionsDao> findByQuestion(Long quesId);
	public List<Answer> deleteByQuestionId(Long quesId);
	
}

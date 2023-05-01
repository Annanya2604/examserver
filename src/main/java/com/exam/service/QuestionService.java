package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.dao.QuestionsDao;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;

public interface QuestionService {
    public QuestionsDao addQuestion(QuestionsDao questionsDao);
    
    public QuestionsDao updateQuestion(QuestionsDao questionDao,Long quesId,Long optionId);
    
    public List<Questions> getQuestions();
    
    public QuestionsDao getQuestionById(Long quesId );
    
    public List<Questions> getQuestionsOfQuix(Quiz quiz);
    
    public List<QuestionsDao> findByQuiz(Long quizId);
    
    public void deleteQuestionsById(Long quesId);
//    public List<Questions> deleteByQuizId(Long quizId,Long quesId);
}

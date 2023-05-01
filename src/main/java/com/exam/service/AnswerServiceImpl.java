package com.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AnswerDao;
import com.exam.dao.QuestionsDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Standard;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.AnswerRepository;
import com.exam.repository.QuestionsRepository;


@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Answer addAnswer(AnswerDao answerdao) {
		// TODO Auto-generated method stub
		 //ques Marks,ques name,quiz,quesId
 		Answer answer = new Answer();
 		//Standard standard=standardRepository.findById(userDao.getStandard().getStandardId()).get();
		Questions question=questionsRepository.findById(answerdao.getQuestion().getQuesId()).get();
		answer.setOptionName(answerdao.getOptionName());
		answer.setQuestion(question);
		answer.setIsCorrect(answerdao.getIsCorrect());
		//section.setStandard(standard);
		return this.answerRepository.save(answer);
	}
	
	@Override
	public Answer updateAnswer(AnswerDao answerdao, Long optionId) {
		
			// TODO Auto-generated method stub
			Answer answer=answerRepository.findById(optionId).orElseThrow(()->new ResourceNotFoundException("answer does not exist"));
			
			
	 		//Standard standard=standardRepository.findById(userDao.getStandard().getStandardId()).get();
			Questions question=questionsRepository.findById(answerdao.getQuestion().getQuesId()).get();
			answer.setOptionName(answerdao.getOptionName());
			answer.setQuestion(question);
			answer.setIsCorrect(answerdao.getIsCorrect());
			//section.setStandard(standard);
			return this.answerRepository.save(answer);
			
			
		
	}

	@Override
	public List<Answer> getAnswers() {
		return answerRepository.findAll();

	}


	@Override
	public void deleteAnswer(Long id) {
		this.answerRepository.deleteById(id);
		
	}

	

	@Override
	public Answer getAnswerById(Long optionId) {
		// TODO Auto-generated method stub
		return this.answerRepository.findById(optionId).get();
	}
   
//	@Override
//	public List<QuestionsDao> findByQuestion(Long quesId) {
////		Answer answer=new Answer();
////         AnswerDao answerdao=this.answerToDao (answer);
//         List<Questions> questions=this.questionsRepository.findAll();
//         List<QuestionsDao> questionsdao=questions.stream().map((ques)->this.modelMapper.map(ques, QuestionsDao.class)).collect(Collectors.toList());
//         
//         List<AnswerDao> answerdao=Arrays.asList();
//         //answerdao=answers.stream().map((ans)->this.modelMapper.map(answers, AnswerDao.class)).collect(Collectors.toList());
//         
//         for(int i=0;i<questionsdao.size();i++) { 
//           //List<AnswerDao> answerdao=new ArrayList<AnswerDao>();
//           List<Answer> answers=this.answerRepository.findByQuestionId(quesId);
//           
//           answerdao=answers.stream().map((ans)->this.answerToDao(ans)).collect(Collectors.toList());
//           questionsdao.get(i).setAnswer(answerdao);
//         
//           
//         }
//         return questionsdao;
//         
//        
//         
//        // List<Answer> answerlist = answerRepository.findByQuestionId(quesId);
//         //return answerlist;
//
//		
//
//	}
	
//	public AnswerDao addanswer(AnswerDao answerDao) {
//		
//		Answer answer = new Answer();
//		answer = this.daoToAnswer(answerDao);
//		AnswerDao ansDao = new AnswerDao();
//		ansDao = this.answerToDao(answer);
//		return null;
//	}
	
	public AnswerDao answerToDao(Answer answer) {
		AnswerDao answerdao=this.modelMapper.map(answer,AnswerDao.class);
		return answerdao;
	}
	public Answer daoToAnswer(AnswerDao answerDao) {
		Answer answer =this.modelMapper.map(answerDao,Answer.class);
		return answer;
	}
	public QuestionsDao questionToDao(Question question) {
		QuestionsDao questiondao=this.modelMapper.map(question,QuestionsDao.class);
		return questiondao;
	}
	public Questions daoToQuestion(QuestionsDao questionDao) {
		Questions question =this.modelMapper.map(questionDao,Questions.class);
		return question;
	}
	
	@Override
	public List<Answer> deleteByQuestionId(Long quesId) {
		// TODO Auto-generated method stub
		Questions question=questionsRepository.findById(quesId).get();
		List<Answer> answer=new ArrayList<Answer>();
		if(question!=null) {
			//this is a method made in the userRepository 
			answer=answerRepository.findByQuestion(question);//passed the standard id to this method and stored in list
			//looping this list of users and deleting each user by Id
			for(int i=0;i<answer.size();i++) {
				this.answerRepository.deleteById(answer.get(i).getOptionId());
			}
			
		}
		return answer;
	}

}

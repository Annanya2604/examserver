package com.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AnswerDao;
import com.exam.dao.QuestionsDao;
import com.exam.dao.QuizDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Role;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.AnswerRepository;
import com.exam.repository.QuestionsRepository;
import com.exam.repository.QuizRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
     @Autowired 
     private  QuestionsRepository questionsRepository;
     
     @Autowired 
     private   QuizRepository quizrepository;
     
     @Autowired 
     private   AnswerRepository answerRepository;
     
     @Autowired
 	private ModelMapper modelMapper;
     
     @Autowired
     private AnswerServiceImpl answerservice;
     
     @Override
 	public QuestionsDao addQuestion(QuestionsDao questionsDao) {
 		 //ques Marks,ques name,quiz,quesId
 		Questions question = new Questions();
		Quiz quiz=quizrepository.findById(questionsDao.getQuiz().getQuizId()).get();
		question.setQuiz(quiz);
		question.setQuesMarks(questionsDao.getQuesMarks());
		question.setQuesName(questionsDao.getQuesName());
		this.questionsRepository.save(question);
		
//		Answer answer=new Answer();
		for(int i=0;i<questionsDao.getAnswer().size();i++) {
	    	  Answer answer=new Answer();
	    	  answer.setOptionName(questionsDao.getAnswer().get(i).getOptionName());
	    	  answer.setQuestion(question);
	    	  answer.setIsCorrect(questionsDao.getAnswer().get(i).getIsCorrect());
	    	  this.answerRepository.save(answer);
	       }
		//for
		//List<Answer> answerlist =this.answerRepository.findByQuestionId(question.getQuesId());
		//this.answerRepository.save(answer);
		
		return questionsDao;
		
		
		
		
//    	Quiz quiz=quizrepository.findById(questionsDao.getQuiz().getQuizId()).get();
//    	QuizDao quizdao=this.modelMapper.map(quiz, QuizDao.class);
//        Questions question=new Questions();
//    	List<Questions> questions = quizrepository.findByQuizId(question.getQuiz().getQuizId());
//    	List<QuestionsDao> questionsdao=questions.stream().map((ques)->{
//       	 QuestionsDao questiondao = this.modelMapper.map(ques, QuestionsDao.class);
//       	 
//       	       List<AnswerDao> answerdaolist =new ArrayList<AnswerDao>();
//       	       List<Answer> answer =this.answerRepository.findByQuestionId(questiondao.getQuesId());
//       	       for(int i=0;i<answer.size();i++) {
//       	    	   AnswerDao answerdao=this.answerToDao(answer.get(i));
//       	    	   answerdaolist.add(answerdao);
//       	       }
//       	      questiondao.setAnswer(answerdaolist);
//       	     
//       	       
//       	     
//       	 return questiondao;
//       	 
//        }).collect(Collectors.toList());
//    	questionsDao.setQuiz(quizdao);
//    	questionsDao.setQuesMarks(question.getQuesMarks());
//    	questionsDao.setQuesName(question.getQuesName());
    	//return this.questionsRepository.save(questionsDao);
        
 	}

	@Override
	public QuestionsDao updateQuestion(QuestionsDao questionsDao,Long quesId,Long optionId) {
		// TODO Auto-generated method stub
		Questions question=questionsRepository.findById(quesId).orElseThrow(()->new ResourceNotFoundException("question does not exist"));
		
		//Long standardId=userDao.getStandard().getStandardId();
		Quiz quiz=quizrepository.findById(questionsDao.getQuiz().getQuizId()).get();
		//quizdao=quiz.stream().map((quiz)->this.modelMapper.map(quiz, QuizDao.class)).collect(Collectors.toList());
		question.setQuiz(quiz);
		//User user=new User();
		//Long sectionId=userDao.getSection().getSectionId();
		question.setQuesMarks(questionsDao.getQuesMarks());
		question.setQuesName(questionsDao.getQuesName());
		 this.questionsRepository.save(question);
		for(int i=0;i<questionsDao.getAnswer().size();i++) {
			// Answer answer=answerRepository.findByQuestionId(quesId).get(i);
			//Answer answer=answerRepository.findById(optionId).get();
			//Answer answer=answerRepository.findByQuestionId(quesId).get(i);
			Long answerId=questionsDao.getAnswer().get(i).getOptionId();
			Answer answer=answerRepository.findById(answerId).get();
    	    //Answer answer=new Answer();
			  //answer.setOptionId(answerId);
	    	  answer.setOptionName(questionsDao.getAnswer().get(i).getOptionName());
	    	  answer.setQuestion(question);
	    	  answer.setIsCorrect(questionsDao.getAnswer().get(i).getIsCorrect());
	    	  this.answerRepository.save(answer);
	       }
		
		//section.setStandard(standard);
		return questionsDao;
	}

	@Override
	public List<Questions> getQuestions() {
			return questionsRepository.findAll();
		
	}

	@Override
	public QuestionsDao getQuestionById(Long quesId) {
		
			// TODO Auto-generated method stub
		Questions question=new Questions();
		question=this.questionsRepository.findById(quesId).get();
		QuestionsDao questionsDao=this.questionToDao(question);
		//QuestionsDao questionsdao=new QuestionsDao();
//		Quiz quiz=quizrepository.findById(questionsdao.getQuiz().getQuizId()).get();
//		question.setQuiz(quiz);
		question.setQuesMarks(questionsDao.getQuesMarks());
		question.setQuesName(questionsDao.getQuesName());
		List<AnswerDao> answerdaolist =new ArrayList<AnswerDao>();
	       List<Answer> answer =this.answerRepository.findByQuestionId(questionsDao.getQuesId());
	       for(int i=0;i<answer.size();i++) {
	    	   AnswerDao answerdao=this.answerToDao(answer.get(i));
	    	   answerdaolist.add(answerdao);
	       }
	      questionsDao.setAnswer(answerdaolist);
	     
	       
	     
	 return questionsDao;
			 
		
		
	}

	@Override
	public List<Questions> getQuestionsOfQuix(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionsRepository.findByQuiz(quiz);
	}

//	@Override
//	public void deleteQuestionsById(Long quesId) {
//		this.answerservice.deleteByQuestionId(quesId);
//		this.questionsRepository.deleteById(quesId);
//		
//		
//	}
	public void deleteQuestionsById(Long quesId){
		this.answerservice.deleteByQuestionId(quesId);
		List<Answer> answers = answerRepository.findByQuestionId(quesId);
		for(Answer answer : answers) {
			answerRepository.deleteAnswerById(answer.getOptionId());
		}
		questionsRepository.deleteById(quesId);
		
	}
	
//	@Override
//	public List<Questions> deleteByQuizId(Long quizId,Long quesId) {
//		// TODO Auto-generated method stub
//		Quiz quiz=quizrepository.findById(quizId).get();
//		Questions question=questionsRepository.findById(quesId).get();
//		List<Questions> ques=new ArrayList<Questions>();
//		List<Answer> ans=new ArrayList<Answer>();
//		if(quiz!=null) {
//			ques=questionsRepository.findByQuiz(quiz);
//			for(int i=0;i<ques.size();i++) {
//				ques.get(i).setIsDeleted(true);
//				this.questionsRepository.save(ques.get(i));
//				
//			}
//			
//		}
//		
//		if(question!=null) {
//			ans=answerRepository.findByQuestion(question);
//			for(int i=0;i<ans.size();i++ ) {
//				ans.get(i).setIsDeleted(true);
//				this.answerRepository.save(ans.get(i));
//			}
//		}
//		
//			
//		
//		return ques;
//	}
//	
//	public List<Questions> findByQuiz(Long quizId) {
//
//		// List<Section>
//		// sectionlist=sectionRepository.findByStandardId(standard.getStandardId());
//		
//		List<Questions> questionlist = quizrepository.findByQuizId(quizId);
// 
//		// section.forEach(this.sectionRepository.findById(section.get.getSectionId()));
//
//		return questionlist;
//
//	}
	
	public List<QuestionsDao> findByQuiz(Long quizId) {
//	Answer answer=new Answer();
	//List<Questions> questionlist = quizrepository.findByQuizId(quizId);
     List<Questions> questions=this.quizrepository.findByQuizId(quizId);//this.modelMapper.map(ques, QuestionsDao.class)
     List<QuestionsDao> questionsdao=questions.stream().map((ques)->{
    	 QuestionsDao questiondao = this.modelMapper.map(ques, QuestionsDao.class);
    	 
    	       List<AnswerDao> answerdaolist =new ArrayList<AnswerDao>();
    	       List<Answer> answer =this.answerRepository.findByQuestionId(questiondao.getQuesId());
    	       for(int i=0;i<answer.size();i++) {
    	    	   AnswerDao answerdao=this.answerToDao(answer.get(i));
    	    	   answerdaolist.add(answerdao);
    	       }
    	      questiondao.setAnswer(answerdaolist);
    	       	      
    	      
    	      
    	      
    	     
    	       
    	     
    	 return questiondao;
    	 
     }).collect(Collectors.toList());
     
    // List<AnswerDao> answerdao=Arrays.asList();
     //answerdao=answers.stream().map((ans)->this.modelMapper.map(answers, AnswerDao.class)).collect(Collectors.toList());
     
//     for(int i=0;i<questionsdao.size();i++) { 
//       List<Answer> answer =Arrays.asList();
//       answer =this.answerRepository.findByQuestionId(questionsdao.get(i).getQuesId());
//       
//       answerdao=answer.stream().map((ans)->this.answerToDao(ans)).collect(Collectors.toList());
//       questionsdao.get(i).setAnswer(answerdao);
//     
//       
//     }
     
     return questionsdao;
     
    
     
    // List<Answer> answerlist = answerRepository.findByQuestionId(quesId);
     //return answerlist;

	

}
	public AnswerDao answerToDao(Answer answer) {
		AnswerDao answerdao=this.modelMapper.map(answer,AnswerDao.class);
		return answerdao;
	}
	public Answer daoToAnswer(AnswerDao answerDao) {
		Answer answer =this.modelMapper.map(answerDao,Answer.class);
		return answer;
	}
	public QuestionsDao questionToDao(Questions question) {
		QuestionsDao questiondao=this.modelMapper.map(question,QuestionsDao.class);
		return questiondao;
	}
	public Questions daoToQuestion(QuestionsDao questionDao) {
		Questions question =this.modelMapper.map(questionDao,Questions.class);
		return question;
	}

}

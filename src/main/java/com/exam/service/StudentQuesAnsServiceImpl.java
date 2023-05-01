package com.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AnswerDao;
import com.exam.dao.QuestionsDao;
import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.UserDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Role;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.User;
import com.exam.repository.AnswerRepository;
import com.exam.repository.QuestionsRepository;
import com.exam.repository.StudentQuestionAnswerRepository;
import com.exam.repository.UserRepository;

@Service
public class StudentQuesAnsServiceImpl implements StudentQuesAnsService{

	@Autowired
	private QuestionsRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private StudentQuestionAnswerRepository studentqueansRepository;
	@Override
	public StudentQuestionAnswer addStudentAnswer(StudentQuestionAnswerDao studentquesansdao) {
		// TODO Auto-generated method stub
         
         
         
         User user=userRepository.findById(studentquesansdao.getUser().getId()).get();
		 
		 for(int i=0;i<studentquesansdao.getQues().size();i++) {
			 StudentQuestionAnswer quesans = new StudentQuestionAnswer();
			 Questions question=questionRepository.findById(studentquesansdao.getQues().get(i).getQuesId()).get();
			 Answer answer=answerRepository.findById(studentquesansdao.getAnswer().get(i).getOptionId()).get();
			 
			 
			 if(answer.getIsCorrect()==true) {
				 quesans.setQuesMarks(answer.getQuestion().getQuesMarks());
			 }
			 else {
				 quesans.setQuesMarks(0L);
			 }
//			 quesans.setQuesMarks(studentquesansdao.getQues().get(i).getQuesMarks());
			 quesans.setQuestion(question); //studentquesansdao.getQues().get(i)
			 

			 quesans.setAnswer(answer);
			 quesans.setUser(user);
			 this.studentqueansRepository.save(quesans);
			 //studentquesansdao.getQues().get(i).getQuesId()
			 
		 }
		
//		 quesans.setQuestion(question);
		 //quesans.setUser(user);
		 
		
		//User user=new User();
		//Long sectionId=userDao.getSection().getSectionId();
		
		//section.setStandard(standard);
		return null;
	
		
	}
	
//	@Override
//	public List<User> deleteByStuQuesAnsId(Long qaId) {
//		// TODO Auto-generated method stub
//		StudentQuestionAnswer stuqa= studentqueansRepository.findById(qaId).get();
//		List<User> user = new ArrayList<User>();
//		
//		
//		if(stuqa!=null) {
//			//this is a method made in the userRepository 
//			user=userRepository.findByStudentqa(stuqa);//passed the standard id to this method and stored in list
//			//looping this list of users and deleting each user by Id
//			for(int i=0;i<user.size();i++) {
//				
////				this.stuquesansrepository.deleteByUser(user.get(i));
//				user.get(i).setDeleted(true);
//				this.userRepository.save(user.get(i));
//				
//				
//				
//			}
//			
//		}
//		return user;
//	}


	
	
	public List<StudentQuestionAnswer> getStudentQueAns(){
		return studentqueansRepository.findAll();
	}
	public StudentQuestionAnswerDao stuquesansToDao(StudentQuestionAnswer studentquesans) {
		StudentQuestionAnswerDao studentquesansdao=this.modelMapper.map(studentquesans,StudentQuestionAnswerDao.class);
		return studentquesansdao;
	}
	public StudentQuestionAnswer daoTostuquesans(StudentQuestionAnswerDao studentquesansdao) {
		StudentQuestionAnswer studentquesanswer =this.modelMapper.map(studentquesansdao,StudentQuestionAnswer.class);
		return studentquesanswer;
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

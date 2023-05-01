package com.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.StudentQuizDao;
import com.exam.entity.Answer;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.StudentQuiz;
import com.exam.entity.User;
import com.exam.repository.AnswerRepository;
import com.exam.repository.QuestionsRepository;
import com.exam.repository.QuizRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.StudentQuestionAnswerRepository;
import com.exam.repository.StudentQuizRepository;
import com.exam.repository.UserRepository;

@Service
public class StudentQuizServiceImpl implements StudentQuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StandardRepository standardRepository;
	
	@Autowired
	private StudentQuestionAnswerRepository stuquesansrepo;
	
	@Autowired
	private StudentQuizRepository studentquizRepository;
	
	@Autowired
	private QuestionsRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	@Override
	public StudentQuiz addStudentQuiz(StudentQuizDao studentquizdao) {
		StudentQuiz studentquiz=new StudentQuiz();
		Quiz quiz=quizRepository.findById(studentquizdao.getQuiz().getQuizId()).get();
		User user=userRepository.findById(studentquizdao.getUser().getId()).get();
		studentquiz.setAttemptedques(studentquizdao.getAttemptedques());
		Long quesMarks=this.stuquesansrepo.findtotalByUser(studentquizdao.getUser().getId(),studentquizdao.getQuiz().getQuizId() );
		studentquiz.setCorrectAnswer(studentquizdao.getCorrectAnswer());
		studentquiz.setMarksObtained(quesMarks);
		if(quesMarks>=studentquizdao.getQuiz().getPassingMarks()) {
			studentquiz.setResultStatus("Pass");
			}
			else {
				studentquiz.setResultStatus("Fail");
			}
			studentquiz.setQuiz(quiz);
			studentquiz.setUser(user);
			return this.studentquizRepository.save(studentquiz);
		
//		StudentQuestionAnswerDao studentquesansdao=new StudentQuestionAnswerDao();
//		for(int i=0;i<studentquesansdao.getQues().size();i++) {
//			 StudentQuestionAnswer quesans = new StudentQuestionAnswer();
//			 Questions question=questionRepository.findById(studentquesansdao.getQues().get(i).getQuesId()).get();
//			 Answer answer=answerRepository.findById(studentquesansdao.getAnswer().get(i).getOptionId()).get();
//			 
//			 
//			 if(answer.getIsCorrect()==true) {
//				 
//				 Long sum=answer.getQuestion().getQuesMarks();
//				 sum=sum+i;
//				 studentquiz.setMarksObtained(sum);
//			 }
//			 else {
//				 quesans.setQuesMarks(0L);
//			 }
//		}
		 
//		StudentQuestionAnswerDao studentquesansdao=new StudentQuestionAnswerDao();
//		for(int i=0;i<studentquesansdao.getQues().size();i++) {
//			 StudentQuestionAnswer quesans = new StudentQuestionAnswer();
//			 Questions question=questionRepository.findById(studentquesansdao.getQues().get(i).getQuesId()).get();
//			 Answer answer=answerRepository.findById(studentquesansdao.getAnswer().get(i).getOptionId()).get();
//			 
//			 
//			 if(answer.getIsCorrect()==true) {
//				 	//quesans.setQuesMarks(answer.getQuestion().getQuesMarks());
//				 
//				 answer.getQuestion().getQuesMarks();
//				 studentquiz.setMarksObtained(answer.getQuestion().getQuesMarks());
//				
//				 
//			 }
//			 else {
//				 quesans.setQuesMarks(0L);
//			 }
//			 if(answer.getIsCorrect()==true) {
//					studentquiz.setCorrectAnswer(studentquizdao.getCorrectAnswer());
//			 }
//			 else {
//				 studentquiz.setCorrectAnswer(0L);
//			 }
//			 studentquiz.setMarksObtained(studentquizdao.getMarksObtained());
//				
//				//studentquiz.setMarksObtained(studentquizdao.getMarksObtained());
//				if(studentquizdao.getMarksObtained()>studentquizdao.getQuiz().getPassingMarks()) {
//				studentquiz.setResultStatus("Pass");
//				}
//				else {
//					studentquiz.setResultStatus("Fail");
//				}
//				studentquiz.setQuiz(quiz);
//				studentquiz.setUser(user);
//				return this.studentquizRepository.save(studentquiz);
//		}
		
		
		
		//studentquiz.setMarksObtained(stuquesansrepo.findtotalByUser(user));
		
		//studentquiz.setMarksObtained(studentquizdao.getMarksObtained());
		
		
		
	}
	
	public StudentQuiz getQuizAttemptedOrNot(Long id, Long quizId) {
        StudentQuiz studentQuiz = this.studentquizRepository.findByStuQuizId(id, quizId);
        if(studentQuiz!=null) {
        	throw new IllegalArgumentException("You have already attempted the quiz");
        }
        return studentQuiz;
//        return ResponseEntity.status(HttpStatus.OK).body("start the quiz");
        
    }
	
	@Override
	public List<StudentQuiz> getStudentQuiz(){
		return studentquizRepository.findAll();
	}
	
	@Override
	public StudentQuiz findByStuQuizId(Long id,Long quizId) {
		StudentQuiz stuquiz=studentquizRepository.findByStuQuizId(id, quizId);
		return stuquiz;
	}
	
	
	
	
//	public StudentQuestionAnswer addStudentAnswer(StudentQuestionAnswerDao studentquesansdao) {
//		// TODO Auto-generated method stub
//         StudentQuestionAnswer quesans = new StudentQuestionAnswer();
//         Questions question=questionRepository.findById(studentquesansdao.getQues().getQuesId()).get();
//         User user=userRepository.findById(studentquesansdao.getUser().getId()).get();
//		 Answer answer=answerRepository.findById(studentquesansdao.getAnswer().getOptionId()).get();
//		 quesans.setAnswer(answer);
//		 quesans.setQuestion(question);
//		 quesans.setUser(user);
//		 
//		
//		//User user=new User();
//		//Long sectionId=userDao.getSection().getSectionId();
//		
//		//section.setStandard(standard);
//		return this.studentqueansRepository.save(quesans);
//	
//		
//	}
//	@Override
//	public Long countpassedStudent(Quiz quiz) {
//		Long count = studentquizRepository.countBymarksObtainedGreaterThanEqual(quiz.getPassingMarks());
//		return count;
//	}
	@Override
	public List<StudentQuiz> stupass(StudentQuiz stuquiz){
		List<StudentQuiz> list=studentquizRepository.studentpassed(stuquiz.getResultStatus());
//		Long count=quizrepository.countstudentspassed(quiz.getPassingMarks());
		
		return list;
	}
	
	public Long pass(StudentQuiz stuquiz) {
		Long count=studentquizRepository.studentpass(stuquiz.getResultStatus());
		return count;
	}
	
	public Long fail(StudentQuiz stuquiz) {
		Long count=studentquizRepository.studentfail(stuquiz.getResultStatus());
		return count;
	}

}

package com.exam.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AnswerDao;
import com.exam.dao.QuizDao;
import com.exam.dao.SubjectDao;
import com.exam.dao.UserDao;
import com.exam.entity.Questions;
import com.exam.entity.Quiz;
import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuiz;
import com.exam.entity.Subject;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.AnswerRepository;
import com.exam.repository.QuestionsRepository;
import com.exam.repository.QuizRepository;
import com.exam.repository.SectionRepository;
import com.exam.repository.StandardRepository;
import com.exam.repository.StudentQuizRepository;
import com.exam.repository.SubjectRepository;
import com.exam.repository.UserRepository;


@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    private QuizRepository quizrepository;
    
    @Autowired
	private SectionRepository sectionRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
 	private ModelMapper modelMapper;
    
    @Autowired
    private StandardRepository standardRepository;
    
    @Autowired
	private QuestionsRepository questionsRepository;
	
	@Override
	public Quiz addQuiz(QuizDao quizdao) {
		Quiz quiz=new Quiz();
		
		Long id = quizdao.getSubject().getSubjectId();
		Subject subject=subjectRepository.findById(id).get();
		//Section section=sectionRepository.findById(subject.getSection().getSectionId()).get();
		
		quiz.setQuizName(quizdao.getQuizName());
		
		quiz.setStartTime(quizdao.getStartTime());
		quiz.setEndTime(quizdao.getEndTime());
		quiz.setQuizMarks(quizdao.getQuizMarks());
		quiz.setNoOfQues(quizdao.getNoOfQues());
		quiz.setDescription(quizdao.getDescription());
		quiz.setIsActive(quizdao.getIsActive());
		quiz.setCreatedDate(quizdao.getCreatedDate());
		quiz.setUpdatedDate(quizdao.getUpdatedDate());
		quiz.setPassingMarks(quizdao.getPassingMarks());
		quiz.setSubject(subject);
		
		
		
		return this.quizrepository.save(quiz);
		
		
	}

	@Override
	public Quiz updateQuiz(QuizDao quizdao, Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz=quizrepository.findById(quizId).orElseThrow(()->new ResourceNotFoundException("quiz does not exist"));
          
		
		Long id = quizdao.getSubject().getSubjectId();
		Subject subject=subjectRepository.findById(id).get();
		//Section section=sectionRepository.findById(subject.getSection().getSectionId()).get();
		
		quiz.setQuizName(quizdao.getQuizName());
		
		quiz.setStartTime(quizdao.getStartTime());
		quiz.setEndTime(quizdao.getEndTime());
		quiz.setQuizMarks(quizdao.getQuizMarks());
		quiz.setNoOfQues(quizdao.getNoOfQues());
		quiz.setDescription(quizdao.getDescription());
		quiz.setIsActive(quizdao.getIsActive());
		quiz.setCreatedDate(quizdao.getCreatedDate());
		quiz.setUpdatedDate(quizdao.getUpdatedDate());
		quiz.setPassingMarks(quizdao.getPassingMarks());
		quiz.setSubject(subject);

		
		return this.quizrepository.save(quiz);

	}


	@Override
	public List<Quiz> getQuiz() {
		
		return quizrepository.findAll();
	}


	@Override
	public Quiz getQuizById(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizrepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		this.quizrepository.deleteById(quizId);
		
	}
	
	@Override
	public List<Quiz> findByUserId(Long id){
		User user=userRepository.findById(id).get();
		List<Subject> subjectlist=subjectRepository.findByStandardId(user.getStandard().getStandardId());
		List<Quiz> quizlist = quizrepository.findBySubject(subjectlist);
		
		
		
		
		

		return quizlist;
	}
	
	
	
	@Override
	public List<Quiz> deleteByStandardId(Long standardId) {
		// TODO Auto-generated method stub
		Standard standard=standardRepository.findById(standardId).get();
		List<Quiz> quiz=new ArrayList<Quiz>();
		if(standard!=null) {
			//this is a method made in the userRepository 
			quiz=quizrepository.findByStandard(standard);//passed the standard id to this method and stored in list
			//looping this list of users and deleting each user by Id
			for(int i=0;i<quiz.size();i++) {
				
			    quiz.get(i).setIsDeleted(true);
				this.quizrepository.save(quiz.get(i));
			}
			
		}
		return quiz;
	}
	
	@Override
	public Long countQuiz(Quiz quiz) {
		Long count=quizrepository.countQuiz(quiz);
		return count;
	}
	
	@Override
	public Long countQuizbyinactive(Quiz quiz) {
		Long count=quizrepository.countQuizinactive(quiz);
		return count;
	}
	
	@Override
	public void deleteQuizById(Long QuizId) {
		// TODO Auto-generated method stub
		Quiz quiz=this.quizrepository.findById(QuizId).get();
		
//		this.userservice.deleteByStandardId(standardId);
//		this.quizservice.deleteByStandardId(standardId);
//		this.subjectservice.deleteByStandardId(standardId);
//		this.sectionservice.deleteByStandardId(standardId);
		
	}

}

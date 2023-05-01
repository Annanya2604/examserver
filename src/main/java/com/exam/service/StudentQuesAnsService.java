package com.exam.service;

import java.util.List;

import com.exam.dao.StudentQuestionAnswerDao;
import com.exam.dao.SubjectDao;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.User;


public interface StudentQuesAnsService {
	public StudentQuestionAnswer addStudentAnswer(StudentQuestionAnswerDao studentquesansdao);
	public List<StudentQuestionAnswer> getStudentQueAns();
//	public List<User> deleteByStuQuesAnsId(Long qaId);
}

package com.cjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cjc.Dao.StudentDao;
import com.cjc.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired(required=true)
	//@Qualifier("StudnetDAO")
	StudentDao studentDAO;

	@Override
	public int registerdata(Student s) {
		return studentDAO.registerdata(s);
	}

	@Override
	public List<Student> loginCheck(String username, String password) {
		return studentDAO.loginCheck(username, password);
	}

	@Override
	public Student showData(int id) {
		return studentDAO.showData(id);
	}

}

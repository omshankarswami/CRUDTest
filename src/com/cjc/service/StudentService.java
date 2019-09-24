package com.cjc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cjc.model.Student;

@Service
public interface StudentService {
	public int registerdata(Student s);
	public List<Student> loginCheck(String username, String password);
	/*public List<Student> DeleteData(int id);
	public List<Student> editData(int id);
	public List<Student> updatedata(Student stu);*/
	public Student showData(int id);
}

package com.cjc.Dao;

import java.util.List;

import com.cjc.model.Student;





public interface StudentDao {
	
	public int registerdata(Student s);
	public List<Student> loginCheck(String username, String password);
	/*public List<Student> DeleteData(int id);
	public List<Student> editData(int id);
	public List<Student> updatedata(Student stu);*/
	public Student showData(int id);
	

}

package com.dao;

import java.util.List;

import com.model.Student;

public interface DaoInterface {
	
	public int insertStudent(Student s);
	public List<Student> loginCheck(String username,String password);
	public List<Student> deleteStudentById(int sid);
	public Student editStudent(int sid);
	public List<Student> updateStudent(Student s);
}

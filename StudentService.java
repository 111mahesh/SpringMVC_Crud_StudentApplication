package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	
	public int insertStudent(Student s);
	public List<Student> loginCheck(String username,String password);
	public List<Student> deleteStudentById(int sid);
	public Student editStudent(int sid);
	public List<Student> updateStudent(Student s);
}

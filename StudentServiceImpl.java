package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDaoimpl;
import com.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDaoimpl sd;
	
	public int insertStudent(Student s) {
		return sd.insertStudent(s);
	}

	public List<Student> loginCheck(String username, String password) {
		
		return sd.loginCheck(username, password);
	}

	public List<Student> deleteStudentById(int sid) {
		// TODO Auto-generated method stub
		return sd.deleteStudentById(sid);
	}

	public Student editStudent(int sid) {
		// TODO Auto-generated method stub
		return sd.editStudent(sid);
	}

	public List<Student> updateStudent(Student s) {
		// TODO Auto-generated method stub
		return sd.updateStudent(s);
	}

}

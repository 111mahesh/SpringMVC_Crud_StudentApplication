package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentDaoimpl implements DaoInterface {

	@Autowired
	SessionFactory sf;
	
	public int insertStudent(Student s) {
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
			
		int check=(Integer) session.save(s);
		tx.commit();
		session.close();
		
		return check;
	}

	public List<Student> loginCheck(String username, String password) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		List<Student> list= session.createQuery("from Student").list();
		tx.commit();
		session.close();
		
		return list;
	}

	public List<Student> deleteStudentById(int sid) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		int check= session.createQuery(" delete from Student where sid='"+sid+"'").executeUpdate();
		if(check>0)
		{
			List studentlist = session.createQuery("from Student").list();
			tx.commit();
			session.close();
			return studentlist;
		}
		
		
		return null;
	}

	public Student editStudent(int sid) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Student s = (Student) session.createQuery("from Student where sid='"+sid+"'").uniqueResult();
		
		tx.commit();
		session.close();
		return s;
	}

	public List<Student> updateStudent(Student s) {
			
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		int check = session.createQuery("update Student set sname='"+s.getSname()+"',scity='"+s.getScity()+"',sper='"+s.getSper()+"'where sid='"+s.getSid()+"'")
		.executeUpdate();
		List<Student> studentlist=new ArrayList<Student>();
		if(check>0)
		{
			 studentlist = session.createQuery("from Student").list();
			tx.commit();
			session.close();
			return studentlist;
		}
		
		
		return studentlist;
	}
	
	
}

package com.spring.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.data.model.Student;

@Component
public class StudentHibernateDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Student student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	public Student getStudentById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.getTransaction().commit();
		session.close();
		return student;
	}
	public List<Student> getAllStudent() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Student> resultList = session.createQuery("SELECT a FROM Student a", Student.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return resultList;
	}
}

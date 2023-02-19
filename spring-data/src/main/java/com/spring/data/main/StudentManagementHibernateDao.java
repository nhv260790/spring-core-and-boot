package com.spring.data.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.dao.StudentHibernateDao;
import com.spring.data.model.Student;

public class StudentManagementHibernateDao {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentHibernateDao hibernateDao = context.getBean("studentHibernateDao", StudentHibernateDao.class);
		hibernateDao.save(new Student("viet"));
//		Student studentById = hibernateDao.getStudentById(1);
//		System.out.println(studentById);
		List<Student> allStudent = hibernateDao.getAllStudent();
		allStudent.forEach(s->System.out.println(s));
	}

}

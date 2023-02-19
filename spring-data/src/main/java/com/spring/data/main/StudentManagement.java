package com.spring.data.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.dao.StudentJdbcDao;
import com.spring.data.dao.StudentJdbcTemplateDao;
import com.spring.data.model.Student;

public class StudentManagement {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentJdbcTemplateDao jdbcDao = context.getBean("studentJdbcTemplateDao", StudentJdbcTemplateDao.class);
		jdbcDao.deleteStudents();
		jdbcDao.insertStudent(new Student(22,"ho viet"));
		jdbcDao.selectStudents();
		System.out.println(jdbcDao.countStudent());
		System.out.println(jdbcDao.getStudentById(22));
		
	}

}

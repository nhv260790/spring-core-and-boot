package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.service.StudentService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentService studentService = context.getBean("studentService", StudentService.class);
		System.out.println(studentService.getStudents());
	}

}

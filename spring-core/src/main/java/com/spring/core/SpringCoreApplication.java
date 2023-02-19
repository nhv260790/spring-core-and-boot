package com.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.service.StudentService;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentService studentService = context.getBean("studentService", StudentService.class);
		System.out.println(studentService.getStudents());
	}

}

package com.spring.data.main;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.dao.StudentJdbcDao;
import com.spring.data.dao.StudentJdbcTemplateDao;
import com.spring.data.model.Student;
import com.spring.data.service.StudentService;

public class StudentManagementSpringDataJpa {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentService service = context.getBean("studentService", StudentService.class);
//		service.saveWithJpaRepository(new Student(1,"viet"));
//		service.saveWithJpaRepository(new Student(2,"Diem"));
//		service.saveWithJpaRepository(new Student(3,"Nguyen"));
//		service.saveWithJpaRepository(new Student(4,"Nguyen"));
//		service.saveWithJpaRepository(new Student(5,"Nguyen"));
//		service.saveWithJpaRepository(new Student(6,"Nguyen"));
//		service.saveWithJpaRepository(new Student(7,"Nguyen"));
//		service.saveWithJpaRepository(new Student(8,"Nguyen"));
//		service.saveWithJpaRepository(new Student(9,"Nguyen"));
//		service.saveWithJpaRepository(new Student(10,"Nguyen"));
		for (int i = 0; i <= 10; i++) {
			service.saveWithJpaRepository(new Student(i,"viet"+i));
			
		}
//		Student student = service.findFirstByOrderByNameAsc();
//		System.out.println(student);
//		Student student1 = service.findStudentWithId(1);
//		System.out.println(student1);
//		Student student2 = service.findStudentWithIdnative(2);
//		System.out.println(student2);
//		service.findAllStudents();
		service.findAllStudentsNative();
		
		
	}

}

package com.spring.core.service;

import java.util.List;

import com.spring.core.entity.Student;
import com.spring.core.repository.StudentRepository;
import com.spring.core.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudents() {
		return studentRepository.getStudents();
	}
	
	public void setStudentRepositoryImpls(StudentRepository studentRepositoryImpl) {
		System.out.println("Setter injection");
		this.studentRepository = studentRepositoryImpl;
	}
	public StudentServiceImpl() {
		System.out.println("Contructor injection");
	}
	
	
	public StudentServiceImpl(StudentRepository studentRepositoryImpl) {
		System.out.println("Contructor injection with param");
		this.studentRepository = studentRepositoryImpl;
	}
	
	
	
}

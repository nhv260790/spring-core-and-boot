package com.spring.core.repository;

import java.util.Arrays;
import java.util.List;

import com.spring.core.entity.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	@Override
	public List<Student> getStudents() {
		return Arrays.asList(new Student(1,"viet"),new Student(2,"Diem"));
	}
}

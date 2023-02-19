package com.spring.core.repository;

import java.util.List;

import com.spring.core.entity.Student;

public interface StudentRepository {

	List<Student> getStudents();

}
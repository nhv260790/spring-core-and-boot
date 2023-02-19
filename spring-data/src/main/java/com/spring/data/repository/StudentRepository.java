package com.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.data.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findFirstByOrderByNameAsc();
	
	@Query(value = "select s from Student s where s.id = ?1")
	Student findStudentWithId(int id);
	
	@Query(value = "select * from student where id = ?1", nativeQuery = true)
	Student findStudentWithIdNative(int id);
	
	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentsNative();
}

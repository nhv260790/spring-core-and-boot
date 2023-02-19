package com.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.dao.StudentHibernateDao;
import com.spring.data.model.Student;
import com.spring.data.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentHibernateDao studentHibernateDao;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		System.out.println("Save with hibernate dao");
		studentHibernateDao.save(student);
	}
	public void saveWithJpaRepository(Student student) {
		System.out.println("Save with jpa repository");
		studentRepository.save(student);
	}
	public Student findFirstByOrderByNameAsc() {
		return studentRepository.findFirstByOrderByNameAsc();
	}
	public Student findStudentWithId(int id) {
		long start = System.currentTimeMillis();
		Student findStudentWithId = studentRepository.findStudentWithId(id);
		System.out.println(System.currentTimeMillis() - start);
		return findStudentWithId;
	}
	public Student findStudentWithIdnative(int id) {
		long start = System.currentTimeMillis();
		Student findStudentWithIdNative = studentRepository.findStudentWithIdNative(id);
		System.out.println(System.currentTimeMillis() - start);
		return findStudentWithIdNative;
	}
	
	public List<Student> findAllStudentsNative() {
		long start = System.currentTimeMillis();
		List<Student> findAll = studentRepository.findAllStudentsNative();
		System.out.println(System.currentTimeMillis() - start);
		return findAll;
	}
	public List<Student> findAllStudents(){
		long start = System.currentTimeMillis();
		List<Student> findAll = studentRepository.findAll();
		System.out.println(System.currentTimeMillis() - start);
		return findAll;
	}
}

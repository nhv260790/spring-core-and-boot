package com.spring.data.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.spring.data.model.Student;

@Component
public class StudentJdbcDaoSupport extends JdbcDaoSupport{
	

	private final String tableName = "student";

	public StudentJdbcDaoSupport() {
		System.out.println("----Constructor-------");
	}

	
	

	public void insertStudent(Student student) {
		String query = "insert into STUDENT values (" + student.getId() + ",'" + student.getName() + "')";
		this.getJdbcTemplate().execute(query);

	}
	
	public int countStudent() {
		String query = "select count (*) from " + tableName ;
		return this.getJdbcTemplate().queryForObject(query, Integer.class);
	}
	
	@SuppressWarnings("deprecation")
	public Student getStudentById(int id) {
		String queryString = "select * from student where id = ?";
		return this.getJdbcTemplate().queryForObject(queryString, new Object[] {id}, new StudentRowMapper());
	}
	
	public void deleteStudents() {
		String query = "delete from " + tableName;
		this.getJdbcTemplate().execute(query);
		System.out.println("---- deleted all students----");
	}
	
	public void dropStudents() {
		String query = "drop table " + tableName;
		this.getJdbcTemplate().execute(query);
		System.out.println("---- drop table students----");
	}
	
	 public void selectStudents() {
		 String queryString = "select * from " + tableName;
		 List<Student> students = this.getJdbcTemplate().query(queryString, new StudentRowMapper());
		 students.forEach(s -> System.out.println(s));
	    }

}

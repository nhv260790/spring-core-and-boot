package com.spring.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.data.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new Student(resultSet.getInt("id"), resultSet.getString("name"));
	}

}

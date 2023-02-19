package com.spring.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.spring.data.model.Student;

@Component
public class StudentJdbcDao {
	private String jdbcUrl = "jdbc:derby://localhost:1527/education;create=true;";
//    private static String tableName = "restaurants";
	// jdbc Connection
	private Connection connection = null;
	private Statement statement = null;

	public void insertStudent(Student student) {
		createConnection();
		try {
			statement = connection.createStatement();
			statement.execute("insert into student values (" + student.getId() + ",'" + student.getName() + "')");
			statement.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	private void createConnection() {
		if (connection == null) {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				// Get a connection
				connection = DriverManager.getConnection(jdbcUrl);
			} catch (Exception except) {
				except.printStackTrace();
			}
		}
	}

	private void shutdown() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				DriverManager.getConnection(jdbcUrl + ";shutdown=true");
				connection.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}
}

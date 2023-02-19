package com.spring.data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.spring.data.model.Student;

@Component
public class StudentJdbcTemplateDao {
//	private String jdbcUrl = "jdbc:derby://localhost:1527/education;create=true;";
    private static String tableName = "student";
	// jdbc Connection
	private Connection connection = null;
	private Statement statement = null;
	
	
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public StudentJdbcTemplateDao() {
		System.out.println("----Constructor-------");
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("----setDataSource-------");
		this.dataSource = dataSource;
	}

	public void insertStudent(Student student) {
		String query = "insert into STUDENT values (" + student.getId() + ",'" + student.getName() + "')";
		jdbcTemplate.execute(query);
//		createConnection();
//		try {
//			statement = connection.createStatement();
//			statement.execute("insert into STUDENT values (" + student.getId() + ",'" + student.getName() + "')");
//			statement.close();
//		} catch (SQLException sqlExcept) {
//			sqlExcept.printStackTrace();
//		}
	}
	
	public int countStudent() {
		String query = "select count (*) from " + tableName;
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	
	@SuppressWarnings("deprecation")
	public Student getStudentById(int id) {
		String queryString = "select * from student where id = ?";
		return jdbcTemplate.queryForObject(queryString, new Object[] {id}, new StudentRowMapper());
	}
	
	public void deleteStudents() {
		String query = "delete from " + tableName;
		jdbcTemplate.execute(query);
		System.out.println("---- deleted all students----");
	}
	
	 public void selectStudents() {
		 String queryString = "select * from " + tableName;
		 List<Student> students = jdbcTemplate.query(queryString, new StudentRowMapper());
		 students.forEach(s -> System.out.println(s));
//		 createConnection();
//	        try
//	        {
//	            statement = connection.createStatement();
//	            ResultSet results = statement.executeQuery("select * from " + tableName);
//	            ResultSetMetaData rsmd = results.getMetaData();
//	            List<Student> students = new ArrayList<Student>();
//	            
//	            while(results.next())
//	            {
//	                int id = results.getInt(1);
//	                String name = results.getString(2);
//	                students.add(new Student(id, name));
//	            }
//	            students.forEach(s -> System.out.println(s));
//	            results.close();
//	            statement.close();
//	        }
//	        catch (SQLException sqlExcept)
//	        {
//	            sqlExcept.printStackTrace();
//	        }
	    }

	private void createConnection() {
		if (connection == null) {
			try {
				System.out.println("----into createConnection----");
//				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				// Get a connection
				connection = dataSource.getConnection();
				System.out.println("----after createConnection----");
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
//				DriverManager.getConnection(jdbcUrl + ";shutdown=true");
				connection.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}
}

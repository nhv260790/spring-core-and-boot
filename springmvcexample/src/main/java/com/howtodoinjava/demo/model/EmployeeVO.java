package com.howtodoinjava.demo.model;

import java.io.Serializable;

public class EmployeeVO implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String password;

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	public EmployeeVO() {
		super();
	}

	public EmployeeVO(String firstName, String password) {
		super();
		this.firstName = firstName;
		this.password = password;
	}

	public EmployeeVO(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getPassword() {
		System.out.println("----------getPassword--------");
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		System.out.println("----------getFirstName--------");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
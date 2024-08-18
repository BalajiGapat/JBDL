package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Employee 
{
	@Id
	// @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int emiId;
	
	private String empName;
	private String email;
	
	public Employee() 
	{
		super();
	}

	public Employee(int emiId, String empName, String email) 
	{
		super();
		this.emiId = emiId;
		this.empName = empName;
		this.email = email;
	}

	public int getEmiId() {
		return emiId;
	}

	public void setEmiId(int emiId) {
		this.emiId = emiId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [emiId=" + emiId + ", empName=" + empName + ", email=" + email + "]";
	}
	
}


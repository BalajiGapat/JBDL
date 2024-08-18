package com.app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee 
{
	@Id
	private int empId;
	
	private String empName;
	
	@Enumerated(value=EnumType.STRING)
	private Designation designation;
	
	@ManyToOne
	@JoinColumn(name="deptId", nullable = false)
	private Department dept;
	
	@CreationTimestamp
	private LocalDateTime created;
	
	@UpdateTimestamp
	private LocalDateTime updated;

	public Employee() 
	{
		super();
	}
	
	public Employee(int empId, String empName, Designation designation) 
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
	}

	public Employee(int empId, String empName, Designation designation, Department dept, LocalDateTime created,
			LocalDateTime updated) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.dept = dept;
		this.created = created;
		this.updated = updated;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", created=" + created + ", updated=" + updated + "]";
	}
	
}

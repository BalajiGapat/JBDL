package com.app.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class Student 
{
	@Id
	private int studId;
	private String studName;
	
	// if StudentAddress contains large number of fields(like => flat_no, place_name ...etc) then use this approach
	@ElementCollection // Separate table is created with field => stud_id, flat_no, place_name
	@JoinTable(name="student_address_map", joinColumns = @JoinColumn(name="studId"))
	private List<StudentAddress> address;

	public Student() 
	{
		super();
	}

	public Student(int studId, String studName, List<StudentAddress> address) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.address = address;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public List<StudentAddress> getAddress() {
		return address;
	}

	public void setAddress(List<StudentAddress> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", address=" + address + "]";
	}
	
	
}

package com.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Department 
{
	@Id
	private int deptId;
	
	private String deptName;
	
	@OneToMany(mappedBy = "dept", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name="deptId") => for uni-direction relationship
	private List<Employee> empList;

	public Department() 
	{
		super();
	}
	
	public Department(int deptId, String deptName) 
	{
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Department(int deptId, String deptName, List<Employee> empList) 
	{
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empList = empList;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) 
	{
		this.empList = empList;
	}

	@Override
	public String toString() 
	{
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", empList=" + empList + "]";
	}
	
}

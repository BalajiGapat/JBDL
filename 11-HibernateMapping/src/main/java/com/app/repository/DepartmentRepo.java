package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.model.Department;
import com.app.model.Designation;
import com.app.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DepartmentRepo 
{
	@PersistenceContext
	private EntityManager em;
	
	public void addDeparment(Department dept)
	{
		em.persist(dept);
		System.err.println("Deparment Added...!!!");
	}
	
	public void addEmployee(Employee emp, int deptId)
	{
		Department dept=em.find(Department.class, deptId);
		
		if(dept!=null)
		{
			emp.setDept(dept);
			em.persist(emp);
		}
		else
			System.out.println("incorrect deptId...!!!");
	}
	
	public void updateEmpDesignation(int empId, Designation desg)
	{
		Employee emp=em.find(Employee.class, empId);
		if(emp!=null)
		{
			emp.setDesignation(desg);
		}
		else
			System.out.println("Incorrect empId...!!!");
	}
	
	public void readDepartment(int deptId)
	{
		Department dept=em.find(Department.class, deptId);
		if(dept!=null)
		{
			System.out.println(dept.getDeptName());
			
			// Spring return proxy object => placeholder // Because of Lazy Loading
			List<Employee> empList=dept.getEmpList();
			
			for(Employee emp : empList)
			{
				System.out.println(emp);
			}
		}
	}
	
	
}

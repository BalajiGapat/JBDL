package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class EmployeeRepository
{
	@PersistenceContext
	private EntityManager em;
	
	// @Transactional // start transaction just before the method call and commit OR rolback transaction just after the method execution completion
	public void addNewEmp(Employee e)
	{
		em.persist(e);
		// e.setEmpName("Virat");
		System.out.println("new emp added...!!!");
	}
	
	
	public Employee searchById(int empId)
	{
		Employee emp=em.find(Employee.class, empId);
		
		if(emp!=null)
			return emp;
		else
			throw new RuntimeException("EMployee not found...!!!");
	}
	
	
	public void updateEmpEmail(int empId, String email)
	{
		Employee emp= em.find(Employee.class, empId);
		
		if(emp!=null)
		{
			emp.setEmail(email);
			System.out.println("Email updated...!!!");
		}
		else
			throw new RuntimeException("Employee not found...!!!");
	}
	
	
	public void allEmps()
	{
		String jpql = "select e from Employee e";
        TypedQuery<Employee> typeQuery = em.createQuery(jpql, Employee.class);
        List<Employee> empList = typeQuery.getResultList();
        
        for (Employee emp : empList) 
            System.out.println(emp);
        
	}
	
	public void addCustomer(Customer c)
	{
		em.persist(c);
		System.out.println("customer added...!!!");
	}
	
	public void addStudent(Student stud)
	{
		em.persist(stud);
		System.out.println("student added...!!!");
	}
	
}

package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.model.Department;
import com.app.model.Designation;
import com.app.model.Employee;
import com.app.repository.DepartmentRepo;

@SpringBootApplication
public class Application 
{
	public static void main(String[] args) 
	{
		ApplicationContext cntx=SpringApplication.run(Application.class, args);
		DepartmentRepo deptRepo=cntx.getBean(DepartmentRepo.class);
		
		Department dept=new Department(123, "Account");
		deptRepo.addDeparment(dept);
		
		Employee emp=new Employee(111, "Balaji", Designation.valueOf("manager".toUpperCase()));
		deptRepo.addEmployee(emp, 123);
		
		deptRepo.updateEmpDesignation(111, Designation.TEAM_LEAD);
		
		deptRepo.readDepartment(123);
	}

}

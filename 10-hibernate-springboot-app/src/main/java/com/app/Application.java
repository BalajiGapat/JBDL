package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.model.Address;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Student;
import com.app.model.StudentAddress;
import com.app.repository.EmployeeRepository;

@SpringBootApplication
public class Application  implements CommandLineRunner
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) // 2
	{
		ApplicationContext cntx= SpringApplication.run(Application.class, args);
		EmployeeRepository empRepo=cntx.getBean(EmployeeRepository.class);
		empRepo.addNewEmp(new Employee(102, "Balaji", "balaji@gmail.com"));
		
		System.out.println("======================");
		Employee emp1= empRepo.searchById(102);
		System.out.println("empName: "+emp1.getEmpName()+" & Email: "+emp1.getEmail());
		
		System.out.println("======================");
		empRepo.updateEmpEmail(102, "gapat@gmail.com");
		Employee emp2= empRepo.searchById(102);
		System.out.println("after update => empName: "+emp2.getEmpName()+" & Email: "+emp2.getEmail());
		
		System.out.println("======================");
		empRepo.allEmps();
		
		System.out.println("======================");
		Customer c=new Customer(201, "Arun", new Address("Ar-123", "Akurdi Pune"));
		empRepo.addCustomer(c);
		
		System.out.println("======================");
		StudentAddress stdAdd1=new StudentAddress("flat-1", "koramangla");
		//StudentAddress stdAdd2=new StudentAddress("flat-2", "HSR Layout");
		List<StudentAddress> addList=new ArrayList<>();
		addList.add(stdAdd1);
		//addList.add(stdAdd2);
		
		Student std=new Student(123, "Rohit", addList);
		empRepo.addStudent(std);
		
	}
	
	@Override // 1
	public void run(String... args) throws Exception
	{
		employeeRepository.addNewEmp(new Employee(101, "Sachin", "sachin@gmail.com"));
	}

}

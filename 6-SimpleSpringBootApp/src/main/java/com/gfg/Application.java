package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{
	public static void main(String[] args) 
	{
		System.out.println("Spring boot started....");
		//following method internally initializes ApplicationContext
		SpringApplication.run(Application.class, args);
	}
}

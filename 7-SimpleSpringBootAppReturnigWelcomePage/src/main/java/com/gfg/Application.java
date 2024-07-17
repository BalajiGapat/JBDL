package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application 
{
	public static void main(String[] args) 
	{
		ApplicationContext cntx=SpringApplication.run(Application.class, args);
		String[] arr=cntx.getBeanDefinitionNames();
//		for(String str : arr)
//			System.out.println("=> "+str);
	}
}

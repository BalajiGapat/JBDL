package com.gfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gfg.repository.SavingAccountRepositoryImpl;
import com.gfg.service.AccountServiceImpl;

public class DriverClass 
{
	public static void main(String[] args)
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		SavingAccountRepositoryImpl sar=ctx.getBean("saving", SavingAccountRepositoryImpl.class);
		System.out.println(sar.creditRepo(5000));
	
		AccountServiceImpl asi=ctx.getBean("getAccountService", AccountServiceImpl.class);
		System.out.println(asi.creditService(15000));
	
	}
}

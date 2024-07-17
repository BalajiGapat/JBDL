package com.gfg.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBUtils 
{
	private Connection connection;
	
	@Value("${mydb.url}")
	private String url;
	
	@Value("${mydb.driver}")
	private String driverName;
	
	@Value("${mydb.username}")
	private String uname;
	
	@Value("${mydb.password}")
	private String password;
	
	
	public Connection getConn()
	{
		return connection;
	}
	
	
	@PostConstruct
	public  void inti()
	{
		try 
		{
			Class.forName(driverName);
			connection=DriverManager.getConnection(url, uname, password);
			System.out.println("Connected successfully with Database...!!!");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void destroy()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}

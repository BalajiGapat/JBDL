package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest 
{
	@Test
	@DisplayName("testHelloMethod")
	public void testDemo() 
	{
		System.out.println("Hello...!!!");
	}
	
	@Test
	public void testAdd()
	{
		Calculator c=new Calculator();
		assertEquals(5, c.add(3, 2));
	}

}

package com.gfg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gfg.Calculator;

public class CalculatorTest 
{
	private Calculator cal;
	
	@BeforeEach
	public void setUpp()
	{
		cal=new Calculator();
	}
	
	@Test
	public void testAdd()
	{
		assertEquals(15, cal.add(7, 8), "The addition of 7 and 8 is 15");
	}
	
	@Test
	public void testDiff()
	{
		assertEquals(4, cal.diff(9, 5));
	}
}

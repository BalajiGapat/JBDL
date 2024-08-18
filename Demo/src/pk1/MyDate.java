package pk1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyDate 
{
	public static void main(String[] args) 
	{
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDate.now().atStartOfDay());
	}
}

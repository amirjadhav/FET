package com.cybage.Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "spring core.." );
		//getting context through class path
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context2.xml");
		
		Employee emp = (Employee) ctx.getBean("e3");		
		System.out.println("hashcode "+ emp.hashCode() + "  "+ emp);
	}
}

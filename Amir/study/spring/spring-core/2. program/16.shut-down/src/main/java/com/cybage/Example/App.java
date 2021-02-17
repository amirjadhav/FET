package com.cybage.Example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "spring core.." );
		//getting context through class path
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context.xml");
		
		Employee emp = (Employee) ctx.getBean("emp");		
		System.out.println("hashcode "+ emp.hashCode() + "  "+ emp);
//		ctx.registerShutdownHook();
		ctx.close();
	}
}

package com.cybage;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
	{

		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = ctx.getBean(Employee.class );
		System.out.println(emp);

		ctx.registerShutdownHook();
	}
}
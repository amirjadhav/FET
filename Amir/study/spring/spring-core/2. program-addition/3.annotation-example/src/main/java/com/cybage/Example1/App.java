package com.cybage.Example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "spring core.." );
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		Employee emp = ctx.getBean(Employee.class, "emp");
		System.out.println(emp);
	}
}

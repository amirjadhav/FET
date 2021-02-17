package com.cybage.Example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main( String[] args )
	{
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context.xml");

		ctx.start();
		Employee emp = (Employee) ctx.getBean("emp");		
		ctx.refresh();
		System.out.println(emp);
		ctx.stop();
	}
}
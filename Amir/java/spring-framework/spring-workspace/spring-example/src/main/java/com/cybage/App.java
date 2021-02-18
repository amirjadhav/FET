package com.cybage;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws  Exception
    {
    	//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
   	    //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    	
    	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	Employee emp = context.getBean("emp", Employee.class);
    	System.out.println(emp.hashCode() + " " + emp);

    	context.registerShutdownHook();			//shutdown container, graceful shutdown
    }
}

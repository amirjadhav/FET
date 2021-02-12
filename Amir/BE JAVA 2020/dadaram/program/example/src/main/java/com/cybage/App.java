package com.cybage;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        //it will start spring container(ioc container) by referring beans.xml
        ConfigurableApplicationContext container
        		= new ClassPathXmlApplicationContext("beans.xml");
        
       container.start();
        
       System.out.println(container.getBean("emp"));
       
       container.stop();
       
       container.registerShutdownHook();	//shut down of container... graceful shutdown
    } 
}
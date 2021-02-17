package com.cybage.Example;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "spring core.." );

		//bean factory using xml from class path		
		//Resource res = new ClassPathResource("context.xml");
		//XmlBeanFactory bfactory = new XmlBeanFactory(res);

		//bean factory using xml from file system
		Resource res = new FileSystemResource("context.xml");
		XmlBeanFactory bfactory = new XmlBeanFactory(res);

		Employee emp = (Employee) bfactory.getBean("emp");
		System.out.println(emp);
	}
}
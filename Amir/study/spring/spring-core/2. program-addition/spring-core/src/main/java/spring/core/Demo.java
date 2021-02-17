package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		
		//it will instantiate container
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context.xml");
		
		
//		ApplicationContext ctx = 
//				new FileSystemXmlApplicationContext("d://context.xml");
		
		
		Employee e1 = ctx.getBean(Employee.class, "myemp");
		System.out.println(e1);	
		
	}
}

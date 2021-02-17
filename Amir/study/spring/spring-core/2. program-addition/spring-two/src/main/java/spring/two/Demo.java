package spring.two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		System.out.println("annotation based application");
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context.xml");
		
		Order ord = ctx.getBean(Order.class);
		System.out.println(ord);

	}
}
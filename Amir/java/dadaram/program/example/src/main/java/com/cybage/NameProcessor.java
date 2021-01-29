package com.cybage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class NameProcessor implements BeanPostProcessor{
	
	public Object postProcessBeforeInitialization(Employee bean, String beanName) throws BeansException {
	
		Employee temp = (Employee) bean;
		temp.setName(temp.getName().toUpperCase());		
		return temp;
	}
}

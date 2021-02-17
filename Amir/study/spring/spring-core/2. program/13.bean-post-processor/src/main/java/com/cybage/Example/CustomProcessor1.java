package com.cybage.Example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CustomProcessor1 implements BeanPostProcessor, Ordered {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before initialization (processor 1)" + bean);
		Employee e = (Employee) bean;
		e.setEmpId(2020);
		e.setName("new name");
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after initialization (processor 1)" + bean);
		return bean;
	}
	public int getOrder() {
		return 0;
	}
}

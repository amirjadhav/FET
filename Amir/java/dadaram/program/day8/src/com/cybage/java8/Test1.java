package com.cybage.java8;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(101, "dm101", 36, 123));
		list.add(new Employee(102, "dm102", 30, 1234));
		list.add(new Employee(103, "dm103", 25, 20000));
		list.add(new Employee(104, "dm104", 42, 25000));
		list.add(new Employee(105, "dm105", 31, 10000));	
		list.add(new Employee(106, "dm106", 22, 50000));
		///crore of records are there
		
		long cnt = list
		.parallelStream()			//it will return stream , it will store in temporary storage
		.filter((e) -> e.getAge() < 30)
		.count();
		
		list
		.stream()
		.forEach(e-> System.out.println(e));
		
		System.out.println("number of employee below 30 : "+ cnt);
	}
}

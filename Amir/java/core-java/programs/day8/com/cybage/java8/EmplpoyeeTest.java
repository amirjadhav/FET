package com.cybage.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmplpoyeeTest {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();

		list.add(new Employee(101, "aj101", 23, 34101));
		list.add(new Employee(104, "AJ104", 26, 10341));
		list.add(new Employee(102, "AJ102", 24, 11234));
		list.add(new Employee(107, "AJ107", 31, 334101));
		list.add(new Employee(105, "AJ105", 27, 3423101));
		list.add(new Employee(106, "AJ106", 28, 34101));
		list.add(new Employee(103, "Aj103", 25, 101234));

		// convert list into stream

//		list
//		.stream()
//		.forEach(new Consumer<Employee>() {
//			@Override
//			public void accept(Employee t) {
//				System.out.println(t);
//				
//			}
//		});

//		list.stream().forEach((e) -> System.out.println(e));

//		list.parallelStream().forEach((e) -> System.out.println(e));
//		list.parallelStream().map(e -> {
//			e.setName(e.getName().toUpperCase());
//			return e;
//		}).forEach((e) -> System.out.println(e));

		// skip first record and show only 3 records
		// list.stream().skip(1).limit(3).sorted((e1, e2) -> e1.getAge() -
		// e2.getAge()).forEach((e) -> System.out.println(e));

		// find first record
		// list.stream().skip(1).limit(3).sorted((e1, e2) -> e1.getAge() -
		// e2.getAge()).findFirst();

		// filter the employee with age
		// list.stream().filter((e)-> e.getAge()>=30).forEach((e) ->
		// System.out.println(e));

		// count number with greater age than 25
		long count = list.stream().filter((e1) -> e1.getAge() < 30).count();
		System.out.print(count);
		//System.out.println("*********************************");
		// System.out.println(list);
	}
}

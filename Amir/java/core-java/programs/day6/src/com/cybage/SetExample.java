package com.cybage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		System.out.println("Set Example");

		//Set<String> skills = new HashSet<>();
		//Set<String> skills = new LinkedHashSet<>();
		
		Set<String> skills = new TreeSet<>();

		skills.add("java");
		skills.add("angular");
		skills.add("react");
		skills.add("aws");
		skills.add("angular");
		skills.add("aws");

		
		System.out.println(skills);
//		
//		for(String s : skills) {
//			System.out.println(s);
//		}
//		
//		Iterator<String> iterator = skills.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		//skills.forEach(System.out::println);
	}
}

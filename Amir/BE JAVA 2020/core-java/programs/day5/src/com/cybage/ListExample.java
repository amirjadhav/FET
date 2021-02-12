package com.cybage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		List<String> skills = new ArrayList<>();

		skills.add("java");
		skills.add("angular");
		skills.add("spring");
		skills.add("spring");
		skills.add(0, "react");

		// printing
		System.out.println("-----using sysout----");
		System.out.println(skills);

		// removing element
		skills.remove(1);
		System.out.println("-----after removal----");
		System.out.println(skills);

		// removing element using object name
		skills.remove("spring");
		System.out.println("-----after removal----");
		System.out.println(skills);

		// searching
		System.out.println("search using index: " + skills.get(2));

		// searching using object
		System.out.println("search using object: " + skills.contains("angular"));

		// searching using object and get index
		System.out.println("search using object and get index: " + skills.lastIndexOf("angular"));

		// sorting - ascending
		Collections.sort(skills);
		System.out.println("after sorting... " + skills);

		// sorting - descending
		Collections.sort(skills, Collections.reverseOrder());
		System.out.println("after sorting... " + skills);
	}
}

package day6;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		System.out.println("set example...");
		//Set<String> skills = new HashSet<>();
		//Set<String> skills = new LinkedHashSet<>();
		//Set<String> skills = new TreeSet<>();		//ascending
		Set<String> skills = new TreeSet<>(Collections.reverseOrder()); //descending
		
		//java, angular, java
		skills.add("java");
		skills.add("angular");
		skills.add("react");
		skills.add("aws");
		skills.add("angular");
		skills.add("react");
		skills.add("aws");
		
		System.out.println(skills);
		
	}
}

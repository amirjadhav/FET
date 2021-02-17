package com.cybage;

public class FirstProgram {
	//main function
	public static void main(String args[]) {
		System.out.println("First program...");
		//block --> variables, data types, control statement, loops
		int salary = 123;
		//data types --> byte(8), short(16), int(32), long(64), 
		//float(32), double(64), boolean(1), char(16)
		long population = 123456789;
		double gdp = 34534534534.345;
		boolean isWorking = true;
		char gender = 'M';
		String name = "Dadaram jadhav";
		System.out.println("Name : "+ name);
		System.out.println("population: "+ population);
		
		String skills[] = {"java", "javascript", "angular"};
		int arr[] = {10, 20, 30, 40, 50};
		System.out.println("skills: "+ skills[0]);
		System.out.println("skills: "+ skills[1]);
		System.out.println("skills: "+ skills[2]);
		
		//looping --> while, do..while, for, shortcut for loop
		for(int i = 0; i < skills.length; i++) {
			System.out.println(skills[i]);
		}
		
		//shortcut for loop, enhanced for loop.
		System.out.println("shortcut for loop");
		for(String s :skills) {
			System.out.println(s);
		}
		
		int j = 0; 
		while(j<arr.length) {
			if(arr[j]==30) {
				//break;			//stop processing of loop
				j++;
				continue; 		//skips this loop
			}
			System.out.println(arr[j]);
			j++;
		}
		myFunction();
		
		
		
	}
	public static void myFunction() {
		System.out.println("this is just another function...");
	}
}
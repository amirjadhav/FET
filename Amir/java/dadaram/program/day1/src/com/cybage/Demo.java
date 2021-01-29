package com.cybage;

import java.util.Arrays;

public class Demo {
	//main method will be called by jvm, if jvm want to pass arguments
	public static void main(String xyz[]){
		//programming logic
		System.out.println("Welcome to java training"); 
		String hobbies[] = new String[5];
		hobbies[0] = "swimming";
		hobbies[1] = "cycling";
		hobbies[2] = "running";
		hobbies[3] = "yoga";
		hobbies[4] = "reading";
		
		String skills [] = {"java", "spring", "angular"};
		int score[] = {10, 30, 45, 34, 87, 35};	//score object
		
		//while, for, do..while, short cut for loop - foreach loop
		for(int i = 0; i < hobbies.length; i++) {	//external iteration
			System.out.println(hobbies[i]);
		}
		System.out.println("----------------------------");
		for(String s:skills) {			//internal iterations --> iteration controlled by jvm
			System.out.println(s);
		}
		
		System.out.println("----------------------------");
		for(int s: score) {
			if(s> 40) {
				System.out.println(s);
			}
		}
		System.out.println("------------sorting----------------");
		Arrays.sort(score);
		for(int s: score) {
				System.out.println(s);
		}
		
		System.out.println("------------searching----------------");
		int pos = Arrays.binarySearch(score, 45654);
		System.out.println("position: "+ pos);
		
		System.out.println("------------copy----------------");
		int copyOfScore[] = Arrays.copyOf(score, score.length);
		for(int s: copyOfScore) {
			System.out.println(s);
		}
		
		int x = 10;
		x |= 3;
		System.out.println(x);
		System.out.println("value of x: "+ x);
	}
}

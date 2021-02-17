package com.cybage;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		System.out.println("age exception demo...");
		Scanner scan = new Scanner(System.in);			//accept input from keyboard
		System.out.println("please enter your age...");
		int age = scan.nextInt();
		try {
			if(age < 18) {
				throw new AgeException("Not eligible! Your age is less than 18...");				
			}else {
				System.out.println("Congrats... you are eligible for voting");
			}
		}catch(AgeException ae) {
			System.out.println(ae.getLocalizedMessage());
		}
	}
}
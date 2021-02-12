package com.cybage;

import java.util.Scanner;

public class UI1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your age...");
		
		int age = scanner.nextInt();
		
		try {
			if(age > 18 ) {
				System.out.println("you are eligible for voting");			
			}else {
				throw new VotingException("not eligible... your age is less than 18 as you entered: "+ age);
			}
		}catch(VotingException ve) {
			System.err.println(ve.getMessage());
		}		
	}
}

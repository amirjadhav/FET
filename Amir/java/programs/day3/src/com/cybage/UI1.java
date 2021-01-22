package com.cybage;

import java.util.Scanner;

public class UI1 {
	public static void main(String[] args) {
		System.out.println("Day 3");

		System.out.println("Enter your age");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();

		try {
			if(num1 > 18) {
				System.out.println("You are eligible");
			}
			else {
				throw new VotingException("You are not eligible for voting");
			}
		} catch (VotingException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
		System.out.println("Program completed");
	}
}

package com.cybage;

import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		System.out.println("Day 3");

		System.out.println("Enter two numbers");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		try {
			int div = num1 / num2;
			System.out.println("Divison is:" + div);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Cannot devide by zero");
			System.err.println(e.getMessage());
		}
		
		System.out.println("Program completed");
	}
}

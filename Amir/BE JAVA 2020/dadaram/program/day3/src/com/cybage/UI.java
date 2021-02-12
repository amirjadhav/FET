package com.cybage;

import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		System.out.println("welcome to day3");

		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter two number for division");
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		
		try {				//runtime problem may occur
			int div = n1 / n2;
			System.out.println("divison is : "+ div);
		}catch(ArithmeticException ae) {			//corrective action
			System.err.println("not able to divide number by 0");	//end users
			System.err.println(ae.getMessage());			//developer
			ae.printStackTrace();
		}finally {
			System.out.println("this block executed irrespective of exception");
			System.out.println("generally useful for resource management");
			scanner.close();
		}
		System.out.println("program completed...");
	}
}

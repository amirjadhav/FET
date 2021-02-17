package com.cybage;

public class Demo {
	public static void main(String[] args) {
		System.out.println("exception handlig demo...");
		
		int a = 10;
		int b = 5;
		try {
			int div = a/b;
			System.out.println("division is : "+ div);
			String name = "dadaram jadhav";
			System.out.println("character at 5th position: "+ name.charAt(5));
		}catch(ArithmeticException ae) {
			System.out.println("cannot divide number by 0");
		}catch(StringIndexOutOfBoundsException se) {
			System.out.println("string not in range...");
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}finally {
			System.out.println("Finally block --> always executes");
		}
	}
}
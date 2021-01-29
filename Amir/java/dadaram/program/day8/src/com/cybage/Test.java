package com.cybage;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("synchronization example...");
		Account account = new Account();
		
		Thread1 t1 = new Thread1(account);
		Thread2 t2 = new Thread2(account);
		
		t2.start();
		t1.start();
 
	}
}
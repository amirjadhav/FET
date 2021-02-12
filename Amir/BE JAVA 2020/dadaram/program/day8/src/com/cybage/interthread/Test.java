package com.cybage.interthread;

public class Test {
	public static void main(String[] args) {
		Account account = new Account();

		new Thread() {
			public void run() {
				account.withdraw(40000);
			};
		}.start();
		
		new Thread() {
			public void run() {
				account.deposit(10000);
			};
		}.start();
	}
}
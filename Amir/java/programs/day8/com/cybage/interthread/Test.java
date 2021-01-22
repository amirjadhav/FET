package com.cybage.interthread;

public class Test {
	public static void main(String[] args) {
		Account account = new Account();

		new Thread() {
			public void run() {
				account.withdraw(200000);
			};
		}.start();

		new Thread() {
			public void run() {
				account.deposit(15000);
			};
		}.start();

	}
}
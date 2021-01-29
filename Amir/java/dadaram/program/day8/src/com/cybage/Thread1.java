package com.cybage;

public class Thread1 extends Thread{
	private Account account;		//property, instance variable, field
	
	public Thread1(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		account.print(10);
		 
	}
}

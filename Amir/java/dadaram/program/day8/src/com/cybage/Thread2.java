package com.cybage;

public class Thread2 extends Thread{
	private Account account;		//property, instance variable, field
	
	public Thread2(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		account.print(25);
		 
	}
}

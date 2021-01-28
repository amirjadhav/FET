package temp.wait;

public class Customer {
	private int balance = 10000;
	synchronized public void withdraw(int amount) {
		System.out.println("withdraw");
		if(this.balance < amount) {
			System.out.println("low balance");
			try {
				wait();
			}catch (Exception e) {					}
		}
		this.balance = this.balance - amount;
		System.out.println("withdraw completed");
	}
	
	synchronized public void deposit(int amount) {
		System.out.println("deposit");	 
		this.balance = this.balance + amount;
		notify();
	}
}

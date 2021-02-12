package temp;

public class Thread2 extends Thread{
	Account a;
	public Thread2(Account a) {
		this.a = a;
	}
	@Override
	public void run() {
		a.updateAccount(20);
	}
}

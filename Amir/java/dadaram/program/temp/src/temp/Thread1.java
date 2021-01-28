package temp;

public class Thread1 extends Thread{
	Account a;
	public Thread1(Account a) {
		this.a = a;
	}
	@Override
	public void run() {
		a.updateAccount(10);
	}
}


public class Thread2 extends Thread {
	private Account account;

	public Thread2(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		account.print(10);
	}
}

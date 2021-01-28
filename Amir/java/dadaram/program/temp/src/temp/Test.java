package temp;

public class Test {
	public static void main(String[] args) {
		Account account = new Account();
		Thread1 t1 = new Thread1(account);
		Thread2 t2 = new Thread2(account);
		t1.start();
		t2.start();
		
	}
}

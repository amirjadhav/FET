package temp;

public class Account {
	public  void updateAccount(int n) {
		synchronized (this) {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getId()+ "   " + (i*n));
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ie) {
					System.out.println(ie.getLocalizedMessage());
				}
			}
			
		}
	}
}

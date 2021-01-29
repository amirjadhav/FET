
public class Account {
	public void print(int n) {
		synchronized (this) {

			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getId() + " " + (i * n));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}

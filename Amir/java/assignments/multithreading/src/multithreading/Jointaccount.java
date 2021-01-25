package multithreading;

public class Jointaccount {
	public static void main(String[] args) {
		System.out.println("Welcome");
		Bank oB = new Bank();
		Person p1 = new Person("Person1", 30, oB);
		Person p2 = new Person("Person2", 30, oB);

		for (int i = 0;; i++) {
			if (oB.getBal() > 0) {
				p1.start();
				p2.start();
			} else {
				break;
			}
		}
		System.err.println("Program completed");
	}

}

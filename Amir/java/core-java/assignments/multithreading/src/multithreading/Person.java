package multithreading;

public class Person extends Thread {
	String name;
	int ammount;
	Bank oB = null;
	Person(String name,int ammount,Bank b) {
		this.name = name;
		this.ammount = ammount;
		oB = b;
	}

	@Override
	public synchronized void run() {
		if(oB.getBal()>this.ammount) {
			oB.withdraw(ammount);
			System.out.println(this.name +" withdrawn " +this.ammount);
		}else
		{
			System.err.println("Account balance is low");
		}
			
	}
}

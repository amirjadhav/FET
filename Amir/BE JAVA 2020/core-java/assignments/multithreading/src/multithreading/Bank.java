package multithreading;

public class Bank {
	int reaming_ammout;

	public Bank() {
		reaming_ammout = 5000;
	}

	public int getBal() {
		return reaming_ammout;
	}
	
	public void withdraw(int ammount) {
		reaming_ammout -= ammount; 
	}

	@Override
	public String toString() {
		return "Bank [reaming_ammout=" + reaming_ammout + "]";
	}

}
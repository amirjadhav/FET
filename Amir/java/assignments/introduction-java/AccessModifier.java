
class AccessModifiers {
	private int number;
	protected String name;
	short salary;
	public int id;

	public AccessModifiers() {
		number = 6749987;
		name = "Amir";
		salary = 12537;
		id = 22716;
	}
}

//Write a program to demonstrate different access modifiers 
public class assignment3 {
	public static void main(String[] args) {
		System.out.println("access modifiers");
		
		
		AccessModifiers oA = new AccessModifiers();
		
		// cannot access private data outside class
		//System.out.println(oA.number);  //gives error
		System.out.println("Id "+oA.id);
		System.out.println("Name "+oA.name);
		System.out.println("salary: "+oA.salary);
		
	}
}

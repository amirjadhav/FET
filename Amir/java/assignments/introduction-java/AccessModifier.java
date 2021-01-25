
class Modifiers {
	private int number;
	protected String name;
	short salary;
	public int id;

	public Modifiers() {
		number = 6749987;
		name = "Amir";
		salary = 12537;
		id = 22716;
	}
}

//Write a program to demonstrate different access modifiers 
 class AccessModifiers {
	public static void main(String[] args) {
		System.out.println("access modifiers");
		
		
		Modifiers oA = new Modifiers();
		
		// cannot access private data outside class
		//System.out.println(oA.number);  //gives error
		System.out.println("Id "+oA.id);
		System.out.println("Name "+oA.name);
		System.out.println("salary: "+oA.salary);
		
	}
}

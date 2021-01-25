
class Account {
    int ammount;

    Account() {
        System.out.println("This is default Constructor");
        ammount = 0;
    }

    Account(int ammount) {
        this.ammount = ammount;
    }

    void display() {
        System.out.println("Into Parameterized constructor");

        System.out.println("Account bal is :" + this.ammount);
    }

}

class ConstructorTest {
    public static void main(String[] args) {
        System.out.println("Constructor types");
        Account account = new Account();
        account.display();

        Account account1 = new Account(100000);
        account1.display();
    }
}
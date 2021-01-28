/*
Assignment #2
Create a class: Bank Account
Create subclasses: 1. Saving & 2.Current
Rate of interest is different for different types of account.
*/

package assignment2;

public class AccountTest {
    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount(1232123, "Amir jadhav", 34200, 12);

        SavingAccount savingAccount = new SavingAccount(344232, "Amir Jadhav", 324231, 11);

        System.out.println(currentAccount.toString());
        System.out.println(savingAccount.toString());
    }
}

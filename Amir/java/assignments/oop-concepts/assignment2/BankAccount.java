package assignment2;

public class BankAccount {
    int accountNumber;
    String accoundHolderName;
    int balance;

    public BankAccount(int accountNumber, String accoundHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accoundHolderName = accoundHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccoundHolderName() {
        return accoundHolderName;
    }

    public void setAccoundHolderName(String accoundHolderName) {
        this.accoundHolderName = accoundHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [accoundHolderName=" + accoundHolderName + ", accountNumber=" + accountNumber + ", balance="
                + balance + "]";
    }

}

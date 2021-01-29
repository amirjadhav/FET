package assignment2;

public class SavingAccount extends BankAccount {
    int rateOfInterest;

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public SavingAccount(int accountNumber, String accoundHolderName, int balance, int rateOfInterest) {
        super(accountNumber, accoundHolderName, balance);
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public String toString() {
        return "CurrentAccount [ accountNumber=" + accountNumber + ", accoundHolderName=" + accoundHolderName
                + ", balance=" + balance + ", rateOfInterest=" + rateOfInterest + "]";
    }

}

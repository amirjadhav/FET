package assignment1;

public class SalesManager extends Manager {
    int commision;

    SalesManager() {
        commision = 0;
    }

    public SalesManager(int commision) {
        this.commision = commision;
    }

    public SalesManager(String name, int id, int salary, int allowance, int commision) {
        super(name, id, salary, allowance);
        this.commision = commision;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    @Override
    int calculateSalary() {
        return super.calculateSalary() + commision;
    }
    @Override
    public String toString() {
        return "SalesManager [commision=" + commision + "]";
    }

}

package assignment1;

public class Manager extends Employee {
    int allowance;

    public Manager() {
        allowance = 0;
    }

    public Manager(String name, int id, int salary, int allowance) {
        super(name, id, salary);
        this.allowance = allowance;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    @Override
    int calculateSalary() {
        return super.calculateSalary() + allowance;
    }

    @Override
    public String toString() {
        return "Manager [allowance=" + allowance + "]";
    }

}

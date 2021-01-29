


export class Employee {
    private ename;
    private dept;
    private salary;

    // constructor
    
    constructor(name, dept, sal) {
       
        this.ename = name;
        this.dept = dept;
        this.salary = sal
    }

    // method
    showEmp() {
        console.log(`Name:${this.ename}  dept:${this.dept} salary:${this.salary}`)
    }


}
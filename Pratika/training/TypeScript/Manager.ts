import {Employee} from './Employee';

class Manager extends Employee{

    private role;


    constructor(){
        super("Pratika"," TraineeSE",30000);
        this.role="Accociate";

    }
show(){
super.showEmp();
}

}
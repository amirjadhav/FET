
// creating normal object
employee = {
    empID:"22716",
    doj:new Date(),
    empName:{empFirstName:"Amir",empLastName:"Jadhav"},
    empSalary:"30k",empDes:"Trainee -SD",
    contactno:['9527300524','9765628567'],
    fullname:()=> {
        return this.employee.empName.empFirstName + " " +this.employee.empName.empLastName;
    }
}


//creating object by constructor

function emp(){this.name="Amir", this.id=101}
var emp1 = new emp()
emp1
 // ->>>>>>>>>>>>>>>>>>>>>>> emp {name: "Amir", id: 101}


// creating object by parameterized constructor

function paraemp(ename,eid){ this.ename = ename ,this.eid = eid}
var emp2 = new paraemp("Vijay",102)
emp2
// ->>>>>>>>>>>>>>>>>>>>>>>paraemp {ename: "Vijay", eid: 102}

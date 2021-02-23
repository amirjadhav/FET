// old way

// function Employee(name,address){  //this is structure of object, just like class in java
//     this.name = name;
//     this.address = address;
// }
// Employee.prototype.display = function(){
//     console.log(this.name + this.address)
// }
// let e1 = new Employee("amir","solapur")
// e1.display();


// // prototype is way to create functions in javascript


//new way

class Employee{
    protected name:string   //instance varible, field, properties
    protected address:string
    constructor(name:string,address:string){
        this.name = name
        this.address= address
    }

    
    public get getName() : string {
        return this.name;
    }
    
    public get getAddress() : string {
        return this.address
    }
    
    
    public set setName(v : string) {
        this.name = v;
    }
        
    
   public print():string{
        return this.name + this.address
    }
}

class Regular extends Employee{
    private salary:number;
    constructor(name:string,address:string,salary:number){
        super(name,address)
        this.salary = salary
    }
    public print():string{
        return this.name + this.address + this.salary
    }
}
let e1 = new Employee("amir ","solapur")
console.log(e1.print());

let re = new Regular("reg emp ","pune",1020);
console.log(re.print());

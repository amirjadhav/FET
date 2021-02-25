class Employee1 {
    protected name: string            //properties , field, instance variable
    protected address: string
    public constructor(name: string, address: string) {
        this.name = name
        this.address = address
    }
    public print(): string {
        return this.name + this.address
    }
    public get returnName() {
        return this.name
    }
    public get returnAddress() {
        return this.address
    }
    public set modifyName(nm:string) {
        this.name = nm
    }
    public set modifyAddress(address:string) {
        this.address = address
    }
}
class Regular extends Employee1 {
    private salary: number
    constructor(name: string, address: string, salary: number) {
        super(name, address)
        this.salary = salary
    }
    public print(): string {
        return this.name + this.address + this.salary
    }
}
let e1 = new Employee1('dmjadhav', 'pune')
e1.modifyName = 'new name'
e1.modifyAddress = 'new address'
 
console.log(e1.returnName, e1.returnAddress)
 
let re = new Regular('reg emp', 'pune1', 12345)
console.log(re.print())
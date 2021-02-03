var value: number=12;
var myName: string="pratika";
var flag :boolean=true;


import {Employee} from './Employee'
// tuple
let tuple: [boolean, number];
tuple = [false, 10]; 

// Enum
enum Color {
    Red = 1,
    Green = 2,
    Blue = 4,
  }
  let c: Color = Color.Green;
console.log(c);

// unknown
let notKnown: unknown = 4;
notKnown = "maybe a string instead";
notKnown = false;

// use interface
var car:Car={name :"Active",color :"black",price :80000}
console.log(car)


// 
var employees:Array<Employee>=[new Employee("Pratika","Traniee SE",30000)]

employees.forEach((employee)=>{
    employee. showEmp();
});
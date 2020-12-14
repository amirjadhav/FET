'use strict'
var student = {
    name: {fname: "Amir",Lname:"Jadhav"},
    id: 22716
}

Object.getOwnPropertyDescriptor(student,"fname");
Object.defineProperty(student,"name",{writable:false})

student.name = {fname: "Vijay" ,Lname: "Dhole"}

console.log(student.name)


//cannot channge value
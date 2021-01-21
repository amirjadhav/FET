'use strict'
var student = {
    name: {fname: "Amir",Lname:"Jadhav"},
    id: 22716
}

Object.getOwnPropertyDescriptor(student,"fname");
Object.defineProperty(student,"name",{enumerable:false})

for(var n in student){
    console.log(n+" :" + student[n]);}

//cannot itterate value
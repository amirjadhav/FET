/*

*Object.freeze : Freezes an object. Other code cannot delete or change its properties.

* Object.seal : Prevents other code from deleting properties of an object.

* Object.assign :Copies the values of all enumerable own properties from one or more source objects to a target object

*/

/*************************************** */
'use strict'

// const obj = {
//     prop: 42
//   };
  
//   Object.freeze(obj);
  
//   obj.prop = 33;
//   // Throws an error in strict mode
  
//   console.log(obj.prop);
//   // expected output: 42
  
  /**************************************************** */


//   const object1 = {
//     property1: 42
//   };
  
//   Object.seal(object1);
//   object1.property1 = 33;
//   console.log(object1.property1);
//   // expected output: 33
  
//    delete object1.property1; // cannot delete when sealed
//    console.log(object1.property1);
//    // expected output: 33

/********************************************************************* */


const target = { a: 1, b: 2 };
const source = { b: 4, c: 5 ,d:10};

const returnedTarget = Object.assign(target, source);

console.log(target);
console.log(source);

// expected output: Object { a: 1, b: 4, c: 5 }

console.log(returnedTarget);
// expected output: Object { a: 1, b: 4, c: 5 }

// let a:number
// a = 10;
// console.log("this is console message" +a)

// const a = 50;
// a = 60;
// var myname = "amir";

// (function () {
//     var localVar = 100;
//     var localVar = "new value";
//     console.log("inside function", myname, localVar);
// })();
// console.log("outside function", myname, localVar);


/* Default parameter */

// function f1(a=100,b){
//     console.log("a : ",a," b: ",b)
// }
// f1(a,b);

// /* Rest operator */ 
// function fun(...arg){
//     console.log(arg);
// }
// // fun("a",1,2,3)
// fun()

/************************************************* */
//Destructuring

// let myArray = [10,20,30,40,50]
// let [a,b] =myArray

// let [n,...arg] = myArray

/************************************************* */


// let myarr = [10, 20, 30, 40, 50, 60, 70]
// let [a, ...b] = myarr
// // let a = myarr[0]
// // let b = myarr[1]
// // let c = myarr[2]
// // let d = myarr[3]
// // let e = myarr[4]
// // let f = myarr[5]
// // let g = myarr[6]
 
// console.log(a)
// console.log(b)
// console.log(b.slice(1, 4))
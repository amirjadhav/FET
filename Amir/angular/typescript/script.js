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
/* Rest operator */
function fun() {
    var arg = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        arg[_i] = arguments[_i];
    }
    console.log(arg);
}
// fun("a",1,2,3)
fun();

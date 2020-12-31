var array = ["mongo","strawberry"];
console.log(array);
var length = array.length;
console.log("Array length is "+ length);

array.forEach((val,i)=>{console.log(val + " at index "+ i)});

array.push("banana");
console.log(array);
array.unshift("apple",);
console.log(array);

array.pop();
console.log(array);

array.shift();
console.log(array);

var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.splice(2, 0, "Lemon", "Kiwi");
console.log(fruits);

var newfruit = fruits.slice(1,4);
console.log("new fruits are :"+newfruit.toString());


var Num_map = [1,2,3,4];
var mapArray = Num_map.map((x)=>(x*x));
console.log(mapArray);
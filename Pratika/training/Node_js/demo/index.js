
const {mydate,myname}=require("./mymodule");

var date=mydate();
console.log("date"+date)
console.log("Hello "+myname())

setInterval(()=>{console.log("hello"+myname())},3000)
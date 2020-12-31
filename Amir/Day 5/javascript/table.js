var table_number = prompt("Enter number")
const number = parseInt(table_number)
var data ="";
for(i=1 ;i<=10;i++){
    data += number + " * " + i + " = " +number *i +"<br>" ;
    var x = document.getElementById("table");
    x.innerHTML =data;
}
var array =[];
function addNumber(){
    var x = document.getElementById("num").value;
    array.push(x);
    console.log(array);

    var y = document.getElementById("numbers").value;
    y.innerHTML = array

}
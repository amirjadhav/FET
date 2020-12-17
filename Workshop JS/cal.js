var flag = true
//function that display value
function display(val) {
  document.getElementById("result").value += val;
}

//function that evaluates the digit and return result
function solve() {
  let x = document.getElementById("result").value;
  let y; 
  try
  {
    y = eval(x);
  }
  catch(err){
    console.log("Invalid Exression")
  }

  if (undefined == y) {
    y = 0;
  }
  console.log(y);
  if (y == "Infinity") {
    y = "Error";
  }
  document.getElementById("result").value = y;
}

//function that clear the display
function clr() {
  document.getElementById("result").value = "";
}

//function to find square root

function sqr() {
  let x = document.getElementById("result").value;
  let r = Math.sqrt(x);
  document.getElementById("result").value = r.toFixed(5);
}

//function to find square of number
function squ() {
  let x = document.getElementById("result").value;
  let r = Math.pow(x, 2);
  document.getElementById("result").value = r.toFixed(5);
}
//function to find cube of number

function cub() {
  let x = document.getElementById("result").value;
  let r = Math.pow(x, 3);
  document.getElementById("result").value = r.toFixed(5);
}

//function to delete last character

function del() {
  let x = document.getElementById("result").value;
  let n = x.slice(0, -1);
  // console.log(n)
  document.getElementById("result").value = n;
}
function findLog(){
  let x = document.getElementById("result").value;
  let r = Math.log10(x);
  document.getElementById("result").value = r.toFixed(5);
}

function sci() {
  let m = document.getElementsByClassName("sci");
  let title = document.getElementsByClassName("title");
  let standerd = document.getElementById("mode")
 // console.log(m);
  if (flag) {
    standerd.value = "std"
    for (var i = 0; i < m.length; i += 1) {
      m[i].style.display = "block";
    }
    title[0].style.width = "515px"
    flag = false
  }
  else{
    standerd.value = "sci"
    for (var i = 0; i < m.length; i += 1) {
      m[i].style.display = "none";
    }
    title[0].style.width = "430px"
   // console.log("called none")
    flag = true
  }
}

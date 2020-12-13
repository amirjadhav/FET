var flag = true;
function change() {
  // var x = document.getElementsByClassName("button")
  var n = document.querySelector("#changecolor");
  if (flag) {
    n.style.color = "red";
    flag = false;
  }
  else{
    n.style.color = "blue";
    flag = true; 
  }
}

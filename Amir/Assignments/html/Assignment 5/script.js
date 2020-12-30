function myFace() {
  var c = document.getElementById("mycanvas");
  var draw = c.getContext("2d");
  draw.beginPath();
  draw.fillStyle = "yellow";
  draw.arc(75, 75, 50, 0, Math.PI * 2, true);
  draw.closePath();
  draw.fill();
}
function myEye() {
  var c = document.getElementById("mycanvas");
  var eye = c.getContext("2d");
  eye.moveTo(55, 50);
  eye.beginPath();
  eye.fillStyle = "black";
  eye.arc(50, 60, 5, 0, Math.PI * 2, true);
  eye.closePath();
  eye.fill();

  eye.beginPath();
  eye.fillStyle = "black";
  //right round eye
  eye.arc(100, 60, 5, 0, Math.PI * 2, true);
  eye.closePath();
  eye.fill();
}
function bodyLoad() {
  myFace();
  myEye();
  mySmile();
}

function mySmile() {
  var c = document.getElementById("mycanvas");
  var smile = c.getContext("2d");
  smile.moveTo(105, 75);
  smile.beginPath();
  smile.strokeStyle = "red";
  smile.arc(75, 85, 20, 0, Math.PI, false);
  smile.stroke();
}

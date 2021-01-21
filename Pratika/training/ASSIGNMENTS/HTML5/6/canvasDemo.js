var canvas = document.getElementById('myCanvas'),
context = canvas.getContext('2d');

context.font = "60px Comic Sans MS";
context.fillStyle = "#5499C7";
context.textAlign = "center";
context.fillText("Oxem Technologies", 450, 100);

make_base();

function make_base()
{
  context.imageSmoothingEnabled = false;

  base_image = new Image();
  base_image.src = 'mobile.jpg';
  base_image.onload = function(){
    context.drawImage(base_image,0, 400, 300, 150);
    console.log("Image is on canvas")
  }

  base_image1 = new Image();
  base_image1.src = 'laptop.jpg';
  base_image1.onload = function(){
    context.drawImage(base_image1,250, 400, 300, 150);
    console.log("Image is on canvas")
  }

  base_image2 = new Image();
  base_image2.src = 'ipad.jpg';
  base_image2.onload = function(){
    context.drawImage(base_image2,600, 400, 300, 150);
    console.log("Image is on canvas")
  }

}

var colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];

var arcWidth = 10;
var radius = 8 * arcWidth;

var drawArc = function( color ){
  context.beginPath();
  context.arc(
    150,
    150,
    radius,
    Math.PI ,
    1.5 * Math.PI
  );
  context.lineWidth = arcWidth;
  context.strokeStyle = color;
  context.stroke();
  context.closePath();
  radius += arcWidth;
};

colors.reverse().forEach( drawArc );
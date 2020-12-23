$(document).ready(function () {
    let pass ="";
    let cpass = "";
   $("#pass").blur(function () { 
       pass = $("#pass").val()
       //alert(pass)
      // console.log(pass)

       
   });

   $("#cpass").blur(function () { 
    cpass = $("#cpass").val()
    console.log(pass)

    //function to check both are same
});
});

function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
  
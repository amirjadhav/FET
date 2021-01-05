function display_email(){
var email=document.getElementById("email").value;
if (email == "" || email == null) {
    valid = false;
    $("#email_error").html("* Please enter email.");
  }
alert(email);
}
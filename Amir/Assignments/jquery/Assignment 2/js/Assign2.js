$(document).ready(function () {
 
  $("#togglePassword").click(function(){
    if($('#pass').prop('type')==="password")
      $('#pass').prop('type','text');
    else{
      $('#pass').prop('type','password');
    }
  });
  
 
});

function phoneNumberValidation(phoneNumber) {
  var phoneno = /^\d{10}$/;
  if (phoneNumber.match(phoneno)) {
    return true;
  } else {
    $("#phone_error").html(
      "* Enter valid 10 digit number like this 9876543210."
    );
    return false;
  }
}
function validate() {
  var valid = true;
  var f_name = $("#f_name").val();
  var l_name = $("#l_name").val();
  var email = $("#email").val();
  var password = $("#password").val();
  var checkedData = [];
  $(".skills").each(function (i) {
    if ($(this).is(":checked")) {
      checkedData.push($(this).val());
    }
  });
  var City = $("#City").val();
  var phone = $("#phone").val();

  if (f_name == "" || f_name == null) {
    valid = false;
    $("#f_name_error").html("* Please enter firstname.");
  } else {
    $("#f_name_error").html("");
  }
  if (l_name == "" || l_name == null) {
    valid = false;
    $("#l_name_error").html("* Please enter lastname.");
  } else {
    $("#l_name_error").html("");
  }
  if (email == "" || email == null) {
    valid = false;
    $("#email_error").html("* Please enter email.");
  } else {
    $("#email_error").html("");
  }
  if (password == "" || password == null) {
    valid = false;
    $("#password_error").html("* Please enter password.");
  } else {
    $("#password_error").html("");
  }
  if (checkedData == "" || checkedData == null) {
    valid = false;
    $("#skills_error").html("* Please choose Skill.");
  } else {
    $("#skills_error").html("");
  }
  if (City == "" || City == null) {
    valid = false;
    $("#City_error").html("* Please choose your City.");
  } else {
    $("#City_error").html("");
  }
  if (phone == "" || phone == null) {
    valid = false;
    $("#phone_error").html("* Please enter your phone number.");
  } else {
    $("#phone_error").html("");
  }
  if (phone != "") {
    valid = phoneNumberValidation(phone);
  }
  if (valid == false) {
    return false;
  } else {
    alert("You form is ready to submit.");
    return true;
  }
}

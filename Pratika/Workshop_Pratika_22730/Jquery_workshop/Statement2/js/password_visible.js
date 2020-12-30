$(document).ready(function () {
  $("#togglePassword").click(function(){
    if($('#pass').prop('type')==="password")
      $('#pass').prop('type','text');
    else{
      $('#pass').prop('type','password');
    }
  });
  
});

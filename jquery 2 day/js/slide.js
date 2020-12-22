$(document).ready(function () {
  $("#b1").click(() => {
    $("div").slideUp(1000);
  });

  $("#b2").click(() => {
    $("div").slideDown(1000);
  });

  $("#b3").click(() => {
    $("div").fadeIn(1000);
  });

  $("#b4").click(() => {
    $("div").fadeOut(1000);
  });   
});

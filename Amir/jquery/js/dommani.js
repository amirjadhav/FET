$(document).ready(() => {
  console.log($("div").html());

  $("div").html("<span> this is jquery ...</span>");
  $("div.div1").css("color", "cyan");
  console.log($("div#div1").css("color"));

  $("p").addClass("test");

  $("button").click(() => {
    $("p").toggleClass("test");

    $('div').toggleClass("test")
    $('div').height(200)
    $('div').width(200)
  });
});

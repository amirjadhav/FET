$(document).ready(function(){
    $("#btn1").click(function(){
      alert("Text: " + $("#test").text());
    });
    $("#btn2").click(function(){
      alert("HTML: " + $("#test").html());
    });

    $("p:first").addClass("test");

    
    
    $("#btn3").click(function(){
        $("p").toggle();
    });

  });
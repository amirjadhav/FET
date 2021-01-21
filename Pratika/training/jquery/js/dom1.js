$(document).ready(function(){
    $("#prev").click(function(){
      
        $("#mydiv").prev().css({"color": "red", "border": "2px solid red"});
      
    });
   
    $("#sibling").click(function(){
       
        $("#mydiv").siblings().css({"color": "yellow", "border": "2px solid yellow"});
      
    });
   

    $("#children").click(function(){
       
        $("#mydiv").children().css({"color": "blue", "border": "2px solid blue"});
      
    });

    
    $("#parent").click(function(){
       
        $("#mydiv").parent().css({"color": "green", "border": "2px solid green"});
      
    });
   

  });
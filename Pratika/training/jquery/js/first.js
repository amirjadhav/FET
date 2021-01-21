

$(document).ready(function(){
    $("#hide_blank").click(function(){
      $("a[target='_blank']").hide();
    });


    $("#hideli").click(function(){
        $("ul li:first-child").hide();
      });


      $("ul li:even").css("background-color","#FA8072");



      var allp =$("section").find("p");
      console.log(allp);

      var directp =$("section").children("p");
      console.log(directp);
  });


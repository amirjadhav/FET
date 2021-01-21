$("document").ready(function(){
 
    $("#slide-down").click(function(){
   // alert("helo");
        $("div").slideDown(1000);
  
    });


    $("#slide-up").click(function(){
      
             $("div").slideUp(1000);
       
         });

         $("#fade-in").click(function(){
      
            $("div").fadeIn(1000);
      
        });

        $("#fade-out").click(function(){
      
            $("div").fadeOut(1000);
      
        });
   
   
    


});
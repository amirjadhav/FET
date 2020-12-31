$("document").ready(function(){

    $("button").click(()=>{


         
        $.ajax({
          url:"https://reqres.in/api/users",
          method:"POST",
          data:{
              "name":$("#name").val(),
              "blood group":$("#blood-group").val()
      
          },
          success:(x)=>{
              alert(x.name+"  posted");
              console.log(x);
          }
        });


    });

});
var flag = true;
$(document).ready(() => {
    $("#button1").click(() => {
      if(flag === true){
        console.log(flag)
      $("p")
      .animate({ width: "10%" })
        .animate({ fontSize: "10px" })
        .animate({ color: "red" })
        .animate({ borderWidth: 2 });
        flag = false
      }
      else{
        $("#button1").click(() => {
        console.log(flag)
          $("p")
          .animate({ width: "98%" })
          .animate({ fontSize: "46px" })
          .animate({ color: "yellow" })
          .animate({ borderWidth: 20 });
        });
        flag = true
      }
    });  
});

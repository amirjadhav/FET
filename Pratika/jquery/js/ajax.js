$("document").ready(function(){

$.ajax({
url:"https://reqres.in/api/users/3",
mathod:"GET",
success:(x)=>{
    console.log(x);
    $("span#id1").append(x.data.first_name +" "+x.data.last_name);
   $("span#id2").append(x.data.email);
   var img=x.data.avatar;

   var drawing="<img src='"+img+"'/>";
   console.log(drawing);
   $("div#img").append(drawing);
}

});


});
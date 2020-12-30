function buttonSeelectFirstOdd(){
  
var e=document.querySelector("li.odd");
e.style.color="Red";
}
function buttonSeelectFirstEven(){
    var e=document.querySelector("li.even");
    e.style.color="Green";
    }
    function buttonSeelectAllOdd(){
        var e=document.querySelectorAll("li.odd");
       for(var i=0;i<e.length;i++){
           e[i].style.color="Pink";
       }
        }
    
        function buttonSeelectAlleven(){
            var e=document.querySelectorAll("li.even");
           for(var i=0;i<e.length;i++){
               e[i].style.color="Yellow";
           }
            }
        
    

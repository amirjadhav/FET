

function fullscreen(){


if("fullscreenEnabled" in document)
{
     if(document.fullscreenEnabled)
     {
          var  element=document.getElementById("box");
          if("requestFullscreen" in element){
              element.requestFullscreen();
          }
    }
    else{
        console.log("user doesn't alllow full screen");

    }
 }
}


function screen_change(){
    if(document.fullscreenElement)
    {
       console.log("currrent full screen element"+(document.fullscreenElement));      

    }
    else{
        if("exitFullscreen" in document){
            document.exitFullscreen();

        }
    }
}

document.addEventListener("fullscreenerror",function(){console.log("fulll screen failed")});
document.addEventListener("fullscreenchange",screen_change);










function fullScreen(){
    console.log("Entered full screen")

    if("fullscreenEnabled" in document){
        if(document.fullscreenEnabled){
            console.log("user allows full screen");
        }
        var element = document.getElementById("box");

        if("requestFullscreen" in element){
            element.requestFullscreen();
        }
    }
    else{
        console.log("User not allow full...");
    }
}

function screen_change(){
    if(document.fullscreenElement){
        console.log("current full screen element is :"+ (document.fullscreenElement));
    }
    else{
        if("exitFullscreen" in document){
            document.exitFullscreen();
        }
    }
}

document.addEventListener("fullscreenchange",screen_change);
document.addEventListener("fullscreenerror",function(){
console.log("Full screen failed..");
});
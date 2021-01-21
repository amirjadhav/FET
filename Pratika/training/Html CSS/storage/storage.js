if(typeof(Storage)!=="undefined"){
    document.getElementById("result").innerHTML="Your browser supports both local and session storage";

}
else{
    document.getElementById("result").innerHTML="Sorry, your browser does not support Web Storage..";

}

function setKey(){
    alert("hello");
    var key=document.getElementById("key").value;
    var value=document.getElementById("value").value;

    localStorage.setItem(key, value);
    sessionStorage.setItem(key, value)
}

function clearkey(){
    localStorage.clear();
}
function clearkeyS(){
    sessionStorage.clear();
}
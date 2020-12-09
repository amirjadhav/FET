if(localStorage && sessionStorage){
    var x = document.getElementById("detectfeatures");
    x.innerHTML="Your browser support both local and session storage";
}
else
{
    var x = document.getElementById("detectfeatures");
    x.innerHTML="Your browser does not support both local and session storage";
}
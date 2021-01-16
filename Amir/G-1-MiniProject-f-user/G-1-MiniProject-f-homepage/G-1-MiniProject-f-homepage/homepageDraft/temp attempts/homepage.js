sessionStorage.setItem("userid", "peter@gmail.com");

// sessionStorage.setItem("lname", "Parker"); 

function signedIn(){
    if(sessionStorage) 
    {
        if(sessionStorage.getItem("userid")!= null)
        {
            var x = document.getElementById("signin");
            x.style.display = "none";            
            var x = document.getElementById("signup");
            x.style.display = "none";
            var x = document.getElementById("profile");
            x.style.display = "inline";
            document.getElementById("prfbtn").innerHTML= ("Hi, " + sessionStorage.getItem("userid"));
        }
    } 
    else 
    {
        alert("Sorry, your account could not be configured.");
    }
    }
$(document).ready(function () {
    
    // $(".GK").click(function (e) {
    //     console.log("click gk");
    //     window.location.replace("C:\Users\pratikagi\Downloads\G-1-MiniProject-f-homepage\Question_display\quiz2.html");
    //     e.preventDefault();
        
    // });
});
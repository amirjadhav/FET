var express=require("express");
var cookieParser=require("cookie-parser");
var app=express();
app.use(cookieParser());

//setter of cookie
app.get('/cookieset',function(req,res){
res.clearCookie();
res.cookie('company','Cybage');
res.cookie('name','Pratika');
res.send("cookie set")
});

app.listen(8000)
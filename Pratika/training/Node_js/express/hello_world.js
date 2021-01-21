const express=require('express');
const app=express();
app.get("/",(req,res)=>{
    res.send("Hello world!!");
}).listen(3000)


//Route params
app.get("/product/:product",(req,res)=>{
res.send("exploring.."+req.params.product)
});

app.route("/user").get((req,res)=>{
    res.send('user-get')
})
app.route("/user").post((req,res)=>{
    res.send("user-post")
})

app.get('/',function(req,res){
    res.send("hello get")
})

app.post('/',function(req,res){
    res.send("hello post")
})
app.delete('/del_user',function(req,res){
    res.send("hello DETETE")
})
app.get('/list_user',function(req,res){
    res.send("page Listing")
})
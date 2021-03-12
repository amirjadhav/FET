const http = require("http");
const express=require("express")
const body_parser=require("body-parser")
const app= express();
app.use(body_parser.urlencoded({extended:false}))


app.use("/add-product",(req,res,next)=>{
    res.send("<form action='/product' method='POST'><input type='text' name='title'> <button type='submit'> Add product</button> </form>")
    })



    app.use("/product",(req,res,next)=>{
       console.log(req.body)
       res.redirect("/") 
   })

app.use("/",(req,res,next)=>{
res.send("hello from express")
})


app.listen(4000,()=>{
        console.log("Listening on post number 4000")
    })

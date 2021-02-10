const express=require('express')
const app=express()
const ejs=require('ejs')
const path=require('path')
app.use(express.static('public'))
const expressLayout=require('express-ejs-layouts')
const PORT=process.env.PORT||3000

app.get('/',(req,res)=>{
    res.render('home')
})

app.get('/cart',(req,res)=>{
    res.render('cart')
})
app.use(expressLayout)

app.set('views',path.join(__dirname,'/resources/views/customers'))
app.set('view engine','ejs')
app.listen(PORT,()=>{
    console.log(`listening on port ${PORT}`)
})
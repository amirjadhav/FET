products=[{pid:1,pname:"Mobile",price:10000},{pid:2,pnmae:"laptop",price:80000},{pid:3,pnmae:"ipad",price:100000}]

const express=require('express');
const app=express();

// app.get('/produt/:id',(req,res)=>{

//     let pro=products.find(element=>req.params.id==element.id);
// )}

app.get('/produt/:id',(req,res)=>{
    let pro=products.find(element=>req.params.id==element.id);
    res.send(pro);
})


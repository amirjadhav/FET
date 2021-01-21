const pug = require('pug');

// Compile the source code
const compiledFunction = pug.compileFile('demo.pug');

console.log(compiledFunction({
  name: 'Timothy'
}));

console.log(compiledFunction({
  name: 'Forbes'
}));


var express=require('express')
var app=express();
app.set("view engine","pug")

app.get('/',(req,res)=>{
    var list=[{name:'Pratika'},{name:"Avadhut"},{name:"Priyanka"}]
    res.render('sample',{list:list});
});

app.listen(8080,function (){
console.log("listening")
})
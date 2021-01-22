const mysql=require('mysql');
var myconnection =mysql.createConnection({
    host:'localhost',
    user:'root',
    password:"cybage@123",
    database:"emp_management"
});
myconnection.connect((err)=>{
    if(err) throw err;
    console.log("connected")
})



//create table
// myconnection.query('create table demo(id int primary key, name varchar(30))',(err,result)=>{
//     if(err) throw err;
//     console.log("table created")
// })


// //insert record
 myconnection.query('insert into demo values(1,"pratika")',(err)=>{
     if(err) throw err;
     console.log("value inserted")
 })

//select query
 myconnection.query('select * from demo',(err,rows,cols)=>{
    if(err) throw err;
    console.log("Employee:",rows[0]);
})



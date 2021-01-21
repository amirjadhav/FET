var fs = require('fs');
 
// var contents = fs.readFileSync('data.txt', 'utf8');
// console.log(contents);
 

//write
// fs.writeFile('data.txt', 'hello!', function (err) {
//     if (err) throw err;
//     console.log('Saved!');
//   });


 //append 
//  fs.appendFile('data.txt','pratika', function (err) {
//     if (err) throw err;
//     console.log('Saved!');
//   });


//buffer
// var fs=require("fs");
// var buf=new Buffer.alloc(1024);
// fs.open("data.txt","r+",function(err,fd){
//     if(err) return console.log(err)
//     fs.read(fd,buf,0,buf.length,0,function(err,bytes){
//         if(err) console.log(err);
//         console.log(bytes+"bytes read");
//         if(bytes>0){
//              console.log(buf.slice(0,bytes).toString())
//         }
//     })
// })





//delete
//   fs.unlink('data.txt', function (err) {
//     if (err) throw err;
//     // if no error, file has been deleted successfully
//     console.log('File deleted!');
// });

file_descriptor = fs.openSync("data.txt"); 
fs.close(file_descriptor, (err) => { 
    if (err) 
    console.error('Failed to close file', err); 
  else { 
    console.log("\n> File Closed successfully"); 
  } 
}); 
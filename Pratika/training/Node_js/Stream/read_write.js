//read
// var fs = require("fs");
// var stream;
// stream = fs.createReadStream("./stream/data.txt");
//  stream.setEncoding("UTF8");
// stream.on("data", function(data) {
//     var chunk = data.toString();
//     console.log(chunk);
// }); 

//write
// var fs = require("fs");
// var stream;
// stream = fs.createWriteStream("./stream/data.txt");

// stream.write("Node.js")
// stream.write("Introduction")
// stream.end();
// stream.on('finish',function(){
//     console.log("finish")
// })
 

//write from one file to another
// var fs = require("fs");
// var readstream=fs.createReadStream("./stream/data.txt")
// var writestream=fs.createWriteStream("./stream/data1.txt")
// readstream.pipe(writestream);


//create zip
const zlib = require("zlib"); 
const fs = require('fs'); 
const inp = fs.createReadStream('./stream/data.txt'); 
const out = fs.createWriteStream('./stream/data.gz'); 
const gzip = zlib.createGzip(); 
inp.pipe(gzip).pipe(out); 
console.log("Gzip created!"); 
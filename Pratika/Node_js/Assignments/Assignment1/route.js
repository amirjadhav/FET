const fs = require("fs");

const routeHandler=(req,res)=>{
 const url = req.url;
 const method = req.method;
 if (url === "/") {
   res.write("<html>");
   res.write("<head><title>Assignment 1</title></head>");
   res.write("<body> <h1>Welcome to my page</h1>");
   res.write(
     '<form action="/create-user" method="POST">Username:<input type="text" name="message"><button type="submit">Send</button></form></body>'
   );
   res.write("</html>");
   return res.end();
 }
 if (url === "/user") {
  res.write("<html>");
  res.write("<body> <ul><li>Pratika</li> <li>Avadhut</li><ul></body>");
 
  res.write("</html>");
  return res.end();
}
 if (url === "/create-user" && method === "POST") {
   const body = [];
   req.on("data", (chunk) => {
     body.push(chunk);
   });
   return req.on("end", () => {
     const bodyParser = Buffer.concat(body).toString();
     const message = bodyParser.split("=")[1];
      console.log("uesrname is"+message)
       fs.writeFile("message.txt", message,(err)=>{
       res.statusCode=302;
       res.setHeader("Location","/");
       return res.end();
     });
   });
  
}
   res.setHeader("Content-Type", "text/html");
   res.write('<html>');
 res.write('<head><title>My First Page</title><head>');
 res.write('<body><h1>Hello from my Node.js Server!</h1></body>');
 res.write('</html>');
   res.end();
}
module.exports=routeHandler;
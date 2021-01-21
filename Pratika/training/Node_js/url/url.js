var http = require('http');
var url = require('url');

const server=http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  const query=url.parse(req.url,true).query;
  let data="hello"+query.name;
  res.write("<h1>"+data+"</h1>");
  res.end();

}).listen(8080);


server.on('listening',function(){
    console.log("listeing.....")
})
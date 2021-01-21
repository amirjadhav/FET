var express  = require('express')
var app  = express()

app.use(express.static('public'))
var server = app.listen(8080, () => {
    console.log('Server is started on 127.0.0.1:8080')
})

app.get('/downloadFile/', (req, res) => {
  res.download('./data.txt');
})
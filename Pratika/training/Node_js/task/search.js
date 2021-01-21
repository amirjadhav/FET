const readline = require('readline');
const fs = require('fs');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('enter character ? ', (answer) => {
  // TODO: Log the answer in a database

 let file= fs.readFile('./task/data.txt', 'utf8' , (err, data) => {
    if (err) {
      console.error(err)
      return
    }
    // let arr = file.split("/\r?\n/");
    // arr.forEach((line, idx)=> {
    //     if(line.includes("keyword")){
    //     console.log((idx+1)+':'+ line);
    //     }
    // });
  //  /(\bt\S+\b)/ig
    const regex = new RegExp('/(\b' + answer + '\S+\b)/ig');
    console.log('/(\\b' + answer + '\S+\\b)/ig')
    console.log(regex.test(data))
    if (regex.test(data)) {
     console.log(data)
    }

  })


  rl.close();
});

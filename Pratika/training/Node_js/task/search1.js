var fs = require("fs");
const readline = require("readline");
//var letter = process.argv[2];
var letter;
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
var writeStream = fs.createWriteStream("./letter.txt");

rl.question("enter character ? ", (answer) => {
  letter = answer;
  rl.close();
});

fs.createReadStream("./data.txt").on("data", function (chunk) {
  var words = chunk.toString().split("\n");
  words.forEach(function (word) {
    var firstLetter = word.charAt(0);
    console.log("first letter " + firstLetter);
    console.log("letter" + letter);
    if (firstLetter == letter) {
      console.log(firstLetter);
      writeStream.write(word + "\n");
      console.log("wrote " + word);
    } else {
    }
  });
});

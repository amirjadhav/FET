const express = require("express");
const app = express();
app.use(express.json());

var users = [
  { id: 1, name: "pratika", company: "cybage" },
  { id: 2, name: "Rutuja", company: "cognizant" },
  { id: 3, name: "Mamta", company: "infosys" }
];

// get request
app.get("/users/:id", function (req, res) {
  const user = users.find((c) => c.id === parseInt(req.params.id));
  if (!user) {
    res.status(404).send("Given user not find");
  }
  debugger;
  res.send(user);
});


//post request
app.post("/users", function (req, res) {
    const user ={
        id:users.length+1,
        name:"Rasika",
        company:"Cognizant"

    };
   users.push(user);
   res.send(user);
  });
  



// listening on port
app.listen(8080, () => console.log("Listening on port 8080"));

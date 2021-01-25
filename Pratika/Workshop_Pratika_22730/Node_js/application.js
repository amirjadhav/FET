//Include modules
const express = require("express");
const Sequelize = require("sequelize");
const bodyParser = require("body-parser");

const app = express();
const port = 3000;
app.use(bodyParser.json());

app.get("/", (req, res) => res.send("Employee App"));

// connection to database
app.listen(port, () => console.log(`employee-app listening on port ${port}!`));
var sequelize = new Sequelize("employee_app", "root", "cybage@123", {
  host: "localhost",
  dialect: "mysql",

  pool: {
    max: 5,
    min: 0,
    idle: 10000,
  },
});

// authenticate database
sequelize
  .authenticate()
  .then(() => {
    console.log("Connection has been established successfully.");
  })
  .catch((err) => {
    console.error("Unable to connect to the database:", err);
  });

//Create table
const EMP = sequelize.define("Employee", {
  empid: Sequelize.INTEGER,
  empname: Sequelize.STRING,
  empsalary: Sequelize.INTEGER,
  empdesgn: Sequelize.STRING,
  deptid: Sequelize.INTEGER,
});
sequelize.sync({ force: true }).then(() => {
  console.log(`Database & tables created!`);
});

sequelize.sync({ force: true }).then(() => {
  console.log(`Database & tables created!`);

  EMP.bulkCreate([
    {
      empid: 1,
      empname: "pratika",
      empsalary: 18000,
      empdesgn: "Traniee SE",
      deptid: "101",
    },
  ]);
});

// Pull a list of all employees 
app.get("/employees", function (req, res) {
    EMP.findAll().then((employee) => res.json(employee));
});

// Pull a single employee  by id 
app.get("/employees/:id", function (req, res) {
    EMP.findAll({ where: { id: req.params.id } }).then((employee) =>
    res.json(employee)
  );
});

// Create an employee 
app.post("/employees", function (req, res) {
    EMP.create({
    empid: req.body.empid,
    empname: req.body.empname,
    empsalary: req.body.empsalary,
    empdesgn: req.body.empdesgn,
    deptid: req.body.deptid,
  }).then(function (employee) {
    res.json(employee);
  });
});


//Update an employee 
app.put('/employees/:id/update', function(req, res) {
    EMP.findByPk(req.params.id).then(function(employee) {
        employee.update({
            empid: req.body.empid,
            empname: req.body.empname,
            empsalary: req.body.empsalary,
            empdesgn: req.body.empdesgn,
            deptid: req.body.deptid,
      }).then((employee) => {
        res.json(employee);
      });
    });
  });
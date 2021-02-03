"use strict";
exports.__esModule = true;
var value = 12;
var myName = "pratika";
var flag = true;
var Employee_1 = require("./Employee");
// tuple
var tuple;
tuple = [false, 10];
// Enum
var Color;
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 4] = "Blue";
})(Color || (Color = {}));
var c = Color.Green;
console.log(c);
// unknown
var notKnown = 4;
notKnown = "maybe a string instead";
notKnown = false;
// use interface
var car = { name: "Active", color: "black", price: 80000 };
console.log(car);
// 
var employees = [new Employee_1.Employee("Pratika", "Traniee SE", 30000)];
employees.forEach(function (employee) {
    employee.showEmp();
});
//# sourceMappingURL=first.js.map
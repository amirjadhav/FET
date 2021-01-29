"use strict";
exports.__esModule = true;
exports.Employee = void 0;
var Employee = /** @class */ (function () {
    // constructor
    function Employee(name, dept, sal) {
        this.ename = name;
        this.dept = dept;
        this.salary = sal;
    }
    // method
    Employee.prototype.showEmp = function () {
        console.log("Name:" + this.ename + "  dept:" + this.dept + " salary:" + this.salary);
    };
    return Employee;
}());
exports.Employee = Employee;
//# sourceMappingURL=Employee.js.map
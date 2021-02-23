// old way
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// function Employee(name,address){  //this is structure of object, just like class in java
//     this.name = name;
//     this.address = address;
// }
// Employee.prototype.display = function(){
//     console.log(this.name + this.address)
// }
// let e1 = new Employee("amir","solapur")
// e1.display();
// // prototype is way to create functions in javascript
//new way
var Employee = /** @class */ (function () {
    function Employee(name, address) {
        this.name = name;
        this.address = address;
    }
    Employee.prototype.print = function () {
        console.log(this.name + this.address);
    };
    return Employee;
}());
var Regular = /** @class */ (function (_super) {
    __extends(Regular, _super);
    function Regular(name, address, salary) {
        var _this = _super.call(this, name, address) || this;
        _this.salary = salary;
        return _this;
    }
    Regular.prototype.print = function () {
        console.log(this.name + this.address + this.salary);
    };
    return Regular;
}(Employee));
var e1 = new Employee("amir ", "solapur");
e1.print();
var re = new Regular("reg emp ", "pune", 1020);
re.print();

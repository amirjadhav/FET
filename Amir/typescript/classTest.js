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
var Employee1 = /** @class */ (function () {
    function Employee1(name, address) {
        this.name = name;
        this.address = address;
    }
    Employee1.prototype.print = function () {
        return this.name + this.address;
    };
    Object.defineProperty(Employee1.prototype, "returnName", {
        get: function () {
            return this.name;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Employee1.prototype, "returnAddress", {
        get: function () {
            return this.address;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Employee1.prototype, "modifyName", {
        set: function (nm) {
            this.name = nm;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Employee1.prototype, "modifyAddress", {
        set: function (address) {
            this.address = address;
        },
        enumerable: false,
        configurable: true
    });
    return Employee1;
}());
var Regular = /** @class */ (function (_super) {
    __extends(Regular, _super);
    function Regular(name, address, salary) {
        var _this = _super.call(this, name, address) || this;
        _this.salary = salary;
        return _this;
    }
    Regular.prototype.print = function () {
        return this.name + this.address + this.salary;
    };
    return Regular;
}(Employee1));
var e1 = new Employee1('dmjadhav', 'pune');
e1.modifyName = 'new name';
e1.modifyAddress = 'new address';
console.log(e1.returnName, e1.returnAddress);
var re = new Regular('reg emp', 'pune1', 12345);
console.log(re.print());

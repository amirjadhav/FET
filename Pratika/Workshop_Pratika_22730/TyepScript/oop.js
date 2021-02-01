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
function calculateDistance(edges, points) {
    var d = new Array(3);
    for (var i_1 = 0; i_1 < edges; i_1++) {
        d[i_1] = Math.sqrt(Math.pow(points[i_1].x - points[(i_1 + 1) % edges].x, 2) +
            Math.pow(points[i_1].y - points[(i_1 + 1) % edges].y, 2));
    }
    return d;
}
// base class
var Shape = /** @class */ (function () {
    function Shape(edges, points) {
        if (points === void 0) { points = []; }
        this.edges = edges;
        this.points = points;
    }
    Shape.prototype.perimeter = function (any) { };
    Shape.prototype.area = function (any, number) { };
    return Shape;
}());
var Traingle = /** @class */ (function (_super) {
    __extends(Traingle, _super);
    function Traingle(edges, points) {
        if (points === void 0) { points = []; }
        return _super.call(this, edges, points) || this;
    }
    Traingle.prototype.perimeter = function (d) {
        var p = 0;
        for (var i_2 = 0; i_2 < this.edges; i_2++) {
            p += d[i_2];
        }
        console.log("The perimeter of traingle is :" + p);
        return p;
    };
    Traingle.prototype.area = function (p, d) {
        var s = p / 2;
        var area = Math.sqrt(s * (s - d[0]) * (s - d[1]) * (s - d[2]));
        console.log("The Area of traingle is :" + area);
    };
    return Traingle;
}(Shape));
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    function Rectangle(edges, points) {
        if (points === void 0) { points = []; }
        return _super.call(this, edges, points) || this;
    }
    Rectangle.prototype.perimeter = function (p) {
        console.log("The perimeter of Rectangle is :" + p);
    };
    Rectangle.prototype.area = function (d) {
        var area = d[0] * d[1];
        console.log("The Area of Rectangle is :" + area);
    };
    return Rectangle;
}(Shape));
var Square = /** @class */ (function (_super) {
    __extends(Square, _super);
    function Square(edges, points) {
        if (points === void 0) { points = []; }
        return _super.call(this, edges, points) || this;
    }
    Square.prototype.perimeter = function (p) {
        console.log("The perimeter of Square is :" + p);
    };
    Square.prototype.area = function (d) {
        var area = d[0] * d[1];
        console.log("The Area of Square is :" + area);
    };
    return Square;
}(Shape));
var Points = /** @class */ (function () {
    function Points(x, y) {
        this.x = x;
        this.y = y;
    }
    return Points;
}());
var pointsArray = [];
// Triangle
var inputEdges = 3;
for (var i = 0; i < 3; i++) {
    pointsArray[i] = new Points(i + 1, i + 2);
}
var d = calculateDistance(inputEdges, pointsArray);
var mytraingle = new Traingle(inputEdges, pointsArray);
var peri = mytraingle.perimeter(d);
mytraingle.area(peri, d);
// rectangle
var inputEdges = 4;
for (var i = 0; i < 4; i++) {
    pointsArray[i] = new Points(i + 1, i + 2);
}
var d1 = calculateDistance(inputEdges, pointsArray);
var p1 = 0;
for (var i_3 = 0; i_3 < inputEdges; i_3++) {
    p1 += d1[i_3];
}
var myRectangle = new Rectangle(inputEdges, pointsArray);
myRectangle.perimeter(p1);
myRectangle.area(d1);
// Square
var inputEdges = 4;
var d2 = calculateDistance(inputEdges, pointsArray);
var p2 = 0;
for (var i_4 = 0; i_4 < inputEdges; i_4++) {
    p2 += d2[i_4];
}
var mySquare = new Square(inputEdges, pointsArray);
mySquare.perimeter(p2);
mySquare.area(d2);

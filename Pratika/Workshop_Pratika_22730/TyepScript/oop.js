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
        console.log(d[i_1]);
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
var Points = /** @class */ (function () {
    function Points(x, y) {
        this.x = x;
        this.y = y;
    }
    return Points;
}());
// var inputEdges:any= prompt("Enter Edges: ");
// // inputEdges=parseInt(inputEdges);
// // var pointsArray = new Points(inputEdges);
var pointsArray = {};
var inputEdges = 3;
// for (var i = 0; i < inputEdges; i++) {
//   var x1 = prompt(`Enter x for : ${i + 1}`);
//   var y1 = prompt(`Enter y for : ${i + 1}`);
//   pointsArray[i] = new Points(x1, y1);
// }
pointsArray[1] = new Points(1, 2);
pointsArray[2] = new Points(3, 4);
pointsArray[3] = new Points(5, 6);
for (var i = 0; i < inputEdges; i++) {
    console.log(pointsArray[i]);
}
var d = calculateDistance(inputEdges, pointsArray);
var mytraingle = new Traingle(inputEdges, pointsArray);
var peri = mytraingle.perimeter(d);
mytraingle.area(peri, d);

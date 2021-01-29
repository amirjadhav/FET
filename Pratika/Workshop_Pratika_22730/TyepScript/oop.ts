function calculateDistance(edges:number, points:any) {
  let d = new Array(3);
  for (let i = 0; i < edges; i++) {
    d[i] = Math.sqrt(
      Math.pow(points[i].x - points[(i + 1) % edges].x, 2) +
        Math.pow(points[i].y - points[(i + 1) % edges].y, 2)
    );
    console.log(d[i]);
  }
  return d;
}

// base class
class Shape {
  protected edges:number;
  protected points:any;
  constructor(edges, points = []) {
    this.edges = edges;
    this.points = points;
  }
  perimeter(any) :any{}
  area(any,number) :void {}
}


class Traingle extends Shape {
  constructor(edges, points = []) {
    super(edges, points);
  }
 perimeter(d) {
    let p = 0;
    for (let i = 0; i < this.edges; i++) {
      p += d[i];
    }
    console.log("The perimeter of traingle is :" + p);
    return p;
  }
  area(p, d) {
    let s = p / 2;
    let area = Math.sqrt(s * (s - d[0]) * (s - d[1]) * (s - d[2]));
    console.log("The Area of traingle is :" + area);
  }
}


class Points {
  protected x:number;
  protected y:number;
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}



// var inputEdges:any= prompt("Enter Edges: ");
// // inputEdges=parseInt(inputEdges);
// // var pointsArray = new Points(inputEdges);
var pointsArray:any={};
var inputEdges:number= 3;
// for (var i = 0; i < inputEdges; i++) {
//   var x1 = prompt(`Enter x for : ${i + 1}`);
//   var y1 = prompt(`Enter y for : ${i + 1}`);

//   pointsArray[i] = new Points(x1, y1);
// }

pointsArray[1] = new Points(1, 2);
pointsArray[2] = new Points(3,4);
pointsArray[3] = new Points(5,6);
for (var i = 0; i < inputEdges; i++) {
  console.log(pointsArray[i]);
}

let d = calculateDistance(inputEdges, pointsArray);
let mytraingle = new Traingle(inputEdges, pointsArray);
let peri = mytraingle.perimeter(d);
mytraingle.area(peri, d);
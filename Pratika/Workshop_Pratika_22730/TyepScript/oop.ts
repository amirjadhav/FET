function calculateDistance(edges:number, points:any) {
  let d = new Array(3);
  for (let i = 0; i < edges; i++) {
    d[i] = Math.sqrt(
      Math.pow(points[i].x - points[(i + 1) % edges].x, 2) +
        Math.pow(points[i].y - points[(i + 1) % edges].y, 2)
    );
   
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

class Rectangle extends Shape {
  constructor(edges, points = []) {
    super(edges, points);
  }
  perimeter(p) {
    console.log("The perimeter of Rectangle is :" + p);
  }
  area(d) {
    let area = d[0] * d[1];
    console.log("The Area of Rectangle is :" + area);
  }
}

class Square extends Shape {
  constructor(edges, points = []) {
    super(edges, points);
  }
  perimeter(p) {
    console.log("The perimeter of Square is :" + p);
  }
  area(d) {
    let area = d[0] * d[1];
    console.log("The Area of Square is :" + area);
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



var pointsArray:any=[];

// Triangle
var inputEdges:number= 3;
for (var i = 0; i < 3; i++) {
  pointsArray[i] = new Points(i+1, i+2);
 }

let d = calculateDistance(inputEdges, pointsArray);
let mytraingle = new Traingle(inputEdges, pointsArray);
let peri = mytraingle.perimeter(d);
mytraingle.area(peri, d);



// rectangle
var inputEdges:number= 4;
for (var i = 0; i < 4; i++) {
  pointsArray[i] = new Points(i+1, i+2);
 }
let d1 = calculateDistance(inputEdges, pointsArray);
  let p1 = 0;
  for (let i = 0; i < inputEdges; i++) {
    p1 += d1[i];
  }
let myRectangle = new Rectangle(inputEdges, pointsArray);
myRectangle.perimeter(p1);
myRectangle.area(d1);

// Square
var inputEdges:number= 4;
let d2 = calculateDistance(inputEdges, pointsArray);
let p2 = 0;
for (let i = 0; i < inputEdges; i++) {
  p2 += d2[i];
}
let mySquare = new Square(inputEdges, pointsArray);
mySquare.perimeter(p2);
mySquare.area(d2);
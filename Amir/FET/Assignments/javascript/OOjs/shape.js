function calculateDistance(edges, points) {
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
  constructor(edges, points = []) {
    this.edges = edges;
    this.points = points;
  }
  perimeter() {}
  area() {}
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
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}

var inputEdges = prompt("Enter Edges: ");

var pointsArray = new Points(inputEdges);
for (var i = 0; i < inputEdges; i++) {
  var x1 = prompt(`Enter x for : ${i + 1}`);
  var y1 = prompt(`Enter y for : ${i + 1}`);

  pointsArray[i] = new Points(x1, y1);
}
for (var i = 0; i < inputEdges; i++) {
  console.log(pointsArray[i]);
}

if (inputEdges == 3) {
  let d = calculateDistance(inputEdges, pointsArray);
  let mytraingle = new Traingle(inputEdges, pointsArray);
  let peri = mytraingle.perimeter(d);
  mytraingle.area(peri, d);
} else if (inputEdges == 4) {
  let d = calculateDistance(inputEdges, pointsArray);
  let p = 0;
  for (let i = 0; i < inputEdges; i++) {
    p += d[i];
  }
  //console.log("perimeter is " + p);
  if (d[0] == d[1] && d[1] == d[2] && d[2] == d[3]) {
    let mySquare = new Square(inputEdges, pointsArray);
    mySquare.perimeter(p);
    mySquare.area(d);
  } else if (d[0] == d[2] && d[1] == d[3]) {
    let myRectangle = new Rectangle(inputEdges, pointsArray);
    myRectangle.perimeter(p);
    myRectangle.area(d);
  } else {
    console.log("Wrong shape");
  }
} else {
  console.log("Wrong shape");
}

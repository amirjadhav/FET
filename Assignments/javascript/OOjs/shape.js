function calculateDistance(edges,points){
    var d = new Array(3);
     for (var i =0 ;i<edges; i++){
        d[i] = Math.sqrt(Math.pow((points[i].x - points[(i+1)%edges].x ),2) + Math.pow((points[i].y - points[(i+1)%edges].y),2))
        console.log(d[i]);
    }
    return d;
}

class Shape{
    constructor(edges,points=[]){
        this.edges = edges ;
        this.points = points ;
    }
    perimeter() {
        
    }
    area(){

    }
}

class Traingle extends Shape{
    constructor(edges, points = []){
        super(edges,points)
    }
    perimeter(){
      var d = calculateDistance(this.edges,this.points)
      var p=0;
      for(let i =0 ; i<this.edges ; i++){
          p += d[i];
      }
      console.log("The perimeter of traingle is :"+ p);
    }
    area(){
        var d = calculateDistance(this.edges,this.points)
        var p = 0;
        for(let i =0 ; i<this.edges ; i++){
            p += d[i];
        }

        var s = p /2;

        var area = Math.sqrt( s * (s-d[0]) *(s-d[1]) *(s-d[2]))
        console.log("The Area of traingle is :"+ area)

    }
}

class Rectangle extends Shape{
    constructor(edges, points = []){
        super(edges,points)
    }
    perimeter(){
        return 10;
    }
    area(){
        return 20;
    }
}

class Square extends Shape{
    constructor(edges, points = []){
        super(edges,points)
    }
    perimeter(){
        return 10;
    }
    area(){
        return 20;
    }
}

class Points{
    constructor(x,y){
        this.x = x ;
        this.y = y ;
    }
}

var inputEdges = prompt("Enter Edges: ")

inputEdges = 3 ;

var pointsArray = new Points(inputEdges)
for (var i = 0; i<inputEdges ;i++){ 
    var x1 =  prompt(`Enter x for : ${i+1}`);
    var y1 =  prompt(`Enter y for : ${i+1}`);

    pointsArray[i] = new Points(x1,y1);
}
for (var i = 0; i<inputEdges ;i++){ 
    console.log(pointsArray[i])
}

if(inputEdges ==3 ){
 let mytraingle = new Traingle(inputEdges,pointsArray)
 mytraingle.perimeter();
 mytraingle.area();

}
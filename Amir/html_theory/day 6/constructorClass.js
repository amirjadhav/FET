class Emplyee{ constructor(){
    this.ename = "John"
    }
    id(){
        return "Hello"
    }
}
console.log(Emplyee.ename)

var e1 = new Emplyee();

console.log(e1)
console.log(e1.ename)
console.log(e1.id())

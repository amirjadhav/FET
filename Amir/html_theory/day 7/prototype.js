class Cat {
    constructor(name,color){
        this.name = name
        this.color = color
    }
}

var muffin = new Cat("muffin","gray")

//undefined
Cat.prototype.age = 5
//5
muffin.age
//5
muffin.age = 6
//6
muffin.age
//6
var puffy = new Cat("puffy","white")
//undefined
puffy.age
//5

Cat.prototype = {age = 10}

var snowbell = new Cat("snowbell","white")
snowbell.age
// 10
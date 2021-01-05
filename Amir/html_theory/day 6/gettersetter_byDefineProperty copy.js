var Person ={
    firstname: 'jimmy',
    lastname: 'smith',
   
   
}

Object.defineProperty(Person,'fullname',{
    get : function() {
        return this.firstname + " " + this.lastname;
    },
    set: function(name){
        var words = name.toString().split(' ');
        this.firstname = words[0] || ' ';
        this.lastname = words[1] || ' ';
    }
})
Person.fullname = 'Jack Franklin'
console.log(Person.firstname)
console.log(Person.lastname)

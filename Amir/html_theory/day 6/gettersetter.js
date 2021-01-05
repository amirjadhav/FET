var Person ={
    firstname: 'jimmy',
    lastname: 'smith',
    get fullname(){
        return this.firstname + " " + this.lastname;
    },
    set fullname(name){
        var words = name.toString().split(' ');
        this.firstname = words[0] || ' ';
        this.lastname = words[1] || ' ';
    }
}
Person.fullname = 'Jack Franklin'
console.log(Person.firstname)
console.log(Person.lastname)

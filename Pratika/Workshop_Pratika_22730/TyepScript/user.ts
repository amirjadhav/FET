// class user
class User {
    protected id: number;
    protected name: string;
    protected address: string;
    protected contact: number;
    constructor(id: number, name: string, address: string, contact: number) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact

    }
    // user with same address
    sameAddr(addr: string): any {

        users.forEach((user) => {
            if (user.address === addr) {
                console.log("Address Matched")
                return user;

            }
        });
    }

    // find user by id
    findById(id: number): any {

        users.forEach((user) => {
            if (user.id === id) {
                console.log("ID Match"+user.id);
                console.log(`name:${user.name} address:${user.address} contact:${user.contact}`)
                return user;

            }
        });
    }


    // insert new user
    insert(id: number, name: string, address: string, contact: number): void {
        users[users.length] = new User(id, name, address, contact);

        console.log("user inserted");
        users.forEach((user) => {
            console.log(user.id)
        });
    }

    // Edit user
    edit(id: number,name: string, address: string, contact: number): void {
        users.forEach((user) => {
            if (user.id === id) {
                user.name=name;
                user.address=address;
                user.contact=contact;
                console.log("information modified ");
                console.log(`name:${user.name} address:${user.address} contact:${user.contact}`)
                return user;

            }
        });
    }

    
// delete user
delete(id:number):void{
    var i:number=0;
    users.forEach((user) => {
      
        if (user.id === id) {
            users.splice(i,1)
            console.log("user deleted");

            users.forEach((user) => {
                console.log(user.id)

            });
          
        }
        i++;
    });
}

}






var users: Array<User> = [new User(1, "pratika", "solapur", 9763006251), new User(2, "divya", "solapur", 9763006251)];



users[0].sameAddr("solapur")

users[0].findById(1);

users[0].insert(3, "rutu", "Satara", 98823222525)

users[0].edit(2,"Pratika","Latur",9763006251)

users[0].delete(2)
// var user1 = new User()
// var user1 = new User()
// class user
var User = /** @class */ (function () {
    function User(id, name, address, contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
    // user with same address
    User.prototype.sameAddr = function (addr) {
        users.forEach(function (user) {
            if (user.address === addr) {
                console.log("Address Match");
                return user;
            }
        });
    };
    // find user by id
    User.prototype.findById = function (id) {
        users.forEach(function (user) {
            if (user.id === id) {
                console.log("ID Match" + user.id);
                console.log("name:" + user.name + " address:" + user.address + " contact:" + user.contact);
                return user;
            }
        });
    };
    // insert new user
    User.prototype.insert = function (id, name, address, contact) {
        users[users.length] = new User(id, name, address, contact);
        console.log("user inserted");
        users.forEach(function (user) {
            console.log(user.id);
        });
    };
    // Edit user
    User.prototype.edit = function (id, name, address, contact) {
        users.forEach(function (user) {
            if (user.id === id) {
                user.name = name;
                user.address = address;
                user.contact = contact;
                console.log("information modified ");
                console.log("name:" + user.name + " address:" + user.address + " contact:" + user.contact);
                return user;
            }
        });
    };
    // delete user
    User.prototype["delete"] = function (id) {
        var i = 0;
        users.forEach(function (user) {
            if (user.id === id) {
                users.splice(i, 1);
                console.log("user deleted");
                users.forEach(function (user) {
                    console.log(user.id);
                });
            }
            i++;
        });
    };
    return User;
}());
var users = [new User(1, "pratika", "solapur", 9763006251), new User(2, "divya", "solapur", 9763006251)];
users[0].sameAddr("solapur");
users[0].findById(1);
users[0].insert(3, "rutu", "Satara", 98823222525);
users[0].edit(2, "Pratika", "Latur", 9763006251);
users[0]["delete"](2);
// var user1 = new User()
// var user1 = new User()

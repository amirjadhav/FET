module.exports = function(app, User, Address) {
    //find all users
    app.get('/user', async (req, res) => {
        res.end(JSON.stringify(await User.findAll({
            attributes: ['userid', 'username', 'email', 'phone', 'image'],
            include: [{
                model: Address,
                as: "address",
                attributes: ["id","type", "address", "longitude", "latitude"]
            }]
        }), null, 2));
    });


    //find specific user using key value pair
    app.get('/user/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["userid"] = req.params.value;
                break;
            case "name":
                condition["username"] = req.params.value.split("-").join(" ");
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        };
        res.end(JSON.stringify(await User.findOne({
            attributes: ['userid', 'username', 'email', 'phone', 'image'],
            include: [{
                model: Address,
                as: "address",
                attributes: ["id","type", "address", "longitude", "latitude"]
            }],
            where: condition
        }), null, 2));
    });

    //add new user
    app.post('/user', async (req, res) => {
        var user = req.body;
        await User.findOne({
            attributes: ['userid', 'username', 'email', 'phone', 'image'],
            where: {email: user.email}
        }).then(async (obj) => {
            if (obj) {
                // If user already exist, give error
                res.end("ERROR");
            } else {
                // If user doesn't exist, create a new user
                res.end(JSON.stringify(await User.create(user), null, 2));
            }
        })
    });

    app.put('/user/:id', async (req, res)=> 
    {
       var user = req.body;
        console.log(user)
        
            res.end(JSON.stringify(await User.update(user, {where: {userid: req.params.id}})
               
            ,null ,2));
    });
}


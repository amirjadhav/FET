module.exports = function(app,DeliveryPerson) {
    app.get('/deliveryPerson', async (req, res) => {
        res.end(JSON.stringify(await DeliveryPerson.findAll({
            attributes: ['did', 'name', 'contact', 'vehicleno', 'address', 'email','rating']
        }), null, 2));
    });


    app.get('/deliveryPerson/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["did"] = req.params.value;
                break;
            case "name":
                condition["name"] = req.params.value.split("-").join(" ");
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        };
        res.end(JSON.stringify(await DeliveryPerson.findOne({
            attributes: ['did', 'name', 'contact', 'vehicleno', 'address','email','rating'],
            where: condition
        }), null, 2));
    });

    app.post('/deliveryPerson', async (req, res) => {
        var deliveryPerson = req.body;
        await DeliveryPerson.findOne({
            attributes: ['did', 'name', 'contact', 'vehicleno', 'address','email','rating'],
            where: {email: deliveryPerson.email}
        }).then(async (obj) => {
            if (obj) {
                // If deliveryperson already exist, give error
                res.end("ERROR");
            } else {
                // If deliveryperson doesn't exist, create a new deliveryperson
                res.end(JSON.stringify(await DeliveryPerson.create(deliveryPerson), null, 2));
            }
        })

    });
//Update address of deliveryPerson
    app.put('/deliveryPerson/:id', async (req, res)=> {
        var deliveryperson = req.body.address;
        await DeliveryPerson.findByPk(req.params.id)
        .then( (address)=>{
            res.end(JSON.stringify( address.update({
                address: deliveryperson
            }) ,null ,2));
        })
    });
}
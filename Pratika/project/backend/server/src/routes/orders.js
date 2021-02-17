module.exports = function(app, Orders, Orderitems, Menu) {
    //find orders if status is not cart
    app.get('/orders', async (req, res) => {
        res.end(JSON.stringify(await Orders.findAll({
            include: [{
                model: Orderitems,
                as: "items",
                attributes: ["mid","quantity", "price"],
                include:[{
                    model: Menu,
                    as: "menu",
                    attributes: ["itemname", "price", "image"]
                }]
            }],
            where: {
                status: {
                    [db.Sequelize.Op.not]: 'Cart'
                }
                }
        }), null, 2));
    });

    //find all orders if status is cart
    app.get('/cart', async (req, res) => {
        res.end(JSON.stringify(await Orders.findAll({
            include: [{
                model: Orderitems,
                as: "items",
                attributes: ["mid","quantity", "price"],
                include:[{
                    model: Menu,
                    as: "menu",
                    attributes: ["itemname", "price", "image"]
                }]
            }],
            where: {status:'Cart'}
        }), null, 2));
    });

    //find all orders acc to userID
    app.get('/orders/:id', async (req, res) => {
        var condition = {};
        condition["oid"] = req.params.id;
        condition["status"] = {
            [db.Sequelize.Op.not]: 'Cart'
        }
        res.end(JSON.stringify(await Orders.findAll({
            include: [{
                model: Orderitems,
                as: "items",
                attributes: ["mid", "quantity"],
                include:[{
                    model: Menu,
                    as: "menu",
                    attributes: ["itemname", "price", "image"]
                }]
            }],
            where: condition
        }), null, 2));
    });

    //CREATE ORDER
    app.post('/orders', async (req, res) => {
        var order = req.body;
        order["rid"]=101;
        order["status"]="Cart";
 
        res.send(JSON.stringify(await Orders.create(order), null, 2)); 
        
            // if (obj) {
            //     // If user already exist, give error
            //     res.end("address already exist");
            // } else {
            //     // If user doesn't exist, create a new user
            //     res.end(JSON.stringify(await Address.create(address), null, 2));
            // }
        
    });

    //update order
    app.put('/orders/:id', async (req, res) => {
        var order = req.body;
        await Orders.findByPk(req.params.id)
        .then( ()=>{
            res.end(JSON.stringify( Orders.update(order, {where: {oid: req.params.id}}) ,null ,2));
        })
    });

    // app.delete('/orders/:id', async (req, res) => {
    //     await Orders.destroy({
    //         where: {
    //             oid: req.params.id,
    //             status: "Cart"
    //         }
    //       }).then(()=>{
    //            res.end("deleted")
    //       });
    // });
}


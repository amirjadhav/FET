module.exports = function(app, Orders, Orderitems, Menu) {
    //find orders if status is not cart
    app.get('/orders', async (req, res) => {
        res.end(JSON.stringify(await Orders.findAll({
            include: [{
                model: Orderitems,
                as: "items",
                attributes: ["mid","quantity"],
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
            attributes: ["uid","oid"],
            include: [{
                model: Orderitems,
                as: "items",
                attributes: ["mid","quantity","srno"],
                include:[{
                    model: Menu,
                    as: "menu",
                    attributes: ["itemname", "price", "image"]
                }]
            }],
            where: {status:'Cart'}
        }), null, 2));
    });

    //find all orders acc to orderID
    app.get('/orders/:id', async (req, res) => {
        var condition = {};
        condition["uid"] = req.params.id;
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

    //find all the orders acc to userID
    app.get('/orders/uid/:id', async (req, res) => {
        var condition = {};
        condition["uid"] = req.params.id;
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
        
    });

    //update order
    app.put('/orders/:id', async (req, res) => {
        var order = req.body;
        await Orders.findByPk(req.params.id)
        .then( ()=>{
            res.end(JSON.stringify( Orders.update(order, {where: {oid: req.params.id}}) ,null ,2));
        })
    });


   // update Order fields
   app.patch('/orders/:id', async (req, res) => {
    var values = req.body;
    var condition = { where: { 
                     oid: req.params.id
                } }; 
    options = { multi: true };
    
    await Orders.update(values, condition , options) .then( ()=>{
 
        res.end(JSON.stringify({"updated": "yes"}))
    });

   
});

}


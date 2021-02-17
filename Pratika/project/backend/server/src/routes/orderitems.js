module.exports = function(app, Orderitems) {

    app.post('/orderitems', async (req, res) => {
        var item = req.body;
        item["mid"]=50001;
        // item["status"]="Cart";

        res.send(JSON.stringify(await Orderitems.create(item), null, 2)); 
        
            // if (obj) {
            //     // If user already exist, give error
            //     res.end("address already exist");
            // } else {
            //     // If user doesn't exist, create a new user
            //     res.end(JSON.stringify(await Address.create(address), null, 2));
            // }
        
    });

    app.delete('/orderitems/:id', async (req, res) => {
        await Orderitems.destroy({
            where: {
                srno: req.params.id,
                // status: "Cart"
            }
        }).then(()=>{
            res.end("deleted")
        });
    });
}
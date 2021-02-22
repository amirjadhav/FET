module.exports = function(app, Orderitems) {

    app.post('/orderitems', async (req, res) => {
        var item = req.body;
        item["mid"]=50001;
        // item["status"]="Cart";

        res.send(JSON.stringify(await Orderitems.create(item), null, 2)); 
    });

    app.delete('/orderitems/:id', async (req, res) => {
        await Orderitems.destroy({
            where: {
                srno: req.params.id
                // status: "Cart"
            }
        }).then(()=>{
            res.end(JSON.stringify({"deleted": "yes"}))
        });
    });


    app.delete('/orderitems/all/:id', async (req, res) => {
        
        await Orderitems.destroy({
            where: {
                oid:req.params.id
            }
        }).then(()=>{
            res.end(JSON.stringify({"deleted": "yes"}))
        });
    });



   // update quantity
   app.patch('/orderitems/:id', async (req, res) => {
    var values = {quantity:req.body.quantity };
    var condition = { where: { 
                     srno: req.params.id
                } }; 
    options = { multi: true };
    
    await Orderitems.update(values, condition , options)
    .then(()=> {
        res.end(JSON.stringify({"updated": "yes"}))
    }) 
});

}
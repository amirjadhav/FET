module.exports = function(app, Orderitems) {

    app.post('/orderitems', async (req, res) => {
        var item = req.body;
       // item["mid"]=50001;
        // item["status"]="Cart";

        res.send(JSON.stringify(await Orderitems.create(item), null, 2)); 
    });

    app.delete('/orderitems/:oid/:mid', async (req, res) => {
        await Orderitems.destroy({
            where: {
                oid: req.params.oid,
                mid: req.params.mid
            }
        }).then(()=>{
            res.end(JSON.stringify({"deleted": "yes"}))
        });
    });

   // update quantity
   app.patch('/orderitems/:oid/:mid', async (req, res) => {
    var values = {quantity:req.body.quantity };
    var condition = { where: { 
                    oid: req.params.oid,
                     mid: req.params.mid
                } }; 
    let options = { multi: true };
    
    await Orderitems.update(values, condition , options)
    .then(()=> {
        res.end(JSON.stringify({"updated": "yes"}))
    }) 
});

}
module.exports = function(app, User, Address) {

    //user
    //add new address
    app.post('/address/:id', async (req, res) => {
        var address = req.body;
        address["userid"]=req.params.id
        await Address.findOne({
            attributes: ['type','userid'],
            where: {userid: req.params.id,
                type:address.type
            }
        }).then(async (obj) => {
           
            if (obj) {
                // If user already exist, give error
                res.end("address already exist");
            } else {
                // If user doesn't exist, create a new user
                res.end(JSON.stringify(await Address.create(address), null, 2));
            }
        })
    });

    //user
   // update address
    app.patch('/address/:id', async (req, res) => {
        var values = {
            type: req.body.type,
            address:req.body.address
        };
        var condition = { where: {id: req.params.id}}; 
        var options = { multi: true };

        await Address.update(values, condition , options).then(() => {
            res.end(JSON.stringify({"updated": true}));
        }); 
    });

    //user
    //delete address 
    app.delete('/address/:id', async (req, res) => {
        await Address.destroy({
            where: {id: req.params.id}
          }).then(()=>{
               res.end(JSON.stringify({"deleted": true}));
          });
    });

}   
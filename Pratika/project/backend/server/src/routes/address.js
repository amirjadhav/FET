module.exports = function(app, User, Address) {

    //add new address
    app.post('/address', async (req, res) => {
        var address = req.body;
        await Address.findOne({
            attributes: ['type','userid'],
            where: {userid: address.userid,
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


   // update address
    app.patch('/address', async (req, res) => {
        var address = req.body;

        var values = {address:req.body.address };
        var condition = { where: {userid: address.userid,
                        type:address.type
                    } }; 
        options = { multi: true };
        
       Address.update(values, condition , options)
        . then(()=> {
            res.end("updated")
        } ) 
    });


    //delete address
    app.delete('/address', async (req, res) => {
        var address = req.body;
+
        await Address.destroy({
            where: {
                userid: address.userid,
                type:address.type
            }
          }).then(()=>{
               res.end("deleted")
          });
    });

}
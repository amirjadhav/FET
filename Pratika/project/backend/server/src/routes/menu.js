


module.exports = function(app, Menu,Category) {
    app.get('/menu', async (req, res) => {
        res.end(JSON.stringify(await Menu.findAll({
           
            attributes: ['mid', 'cid', 'restid', 'itemname', 'price','foodtype','image'],
           include:[{
            model: Category,
            as : "category",
            attributes:["cname"]

           }]
        }), null, 2));
    });


    app.get('/menu/:key/:value', async(req,res)=>{
      
     var condition ={};

        switch(req.params.key){
                case "id":
                condition["restid"]=req.params.value;
                break;
                default:
                condition[req.params.key]=req.params.value.split('-').join(" "); 
        }
        console.log(condition)
        res.end(JSON.stringify(await Menu.findOne({
            attributes:['mid', 'cid', 'restid', 'itemname', 'price','foodtype','image'],
            include: [ {
                model: Category,
                as : "category",
             attributes: ['cname']
            }],
            where: condition
        }),null,2));



    });

}



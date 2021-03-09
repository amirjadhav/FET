module.exports = function(app, Category) {

     //get all category data
    app.get('/category', async (req, res) => {
        res.end(JSON.stringify(await Category.findAll(), null, 2));
    });


    
     //get specific category data
    app.get('/category/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["cid"] = req.params.value;
                break;
            case "name":
                condition["cname"] = req.params.value.split("-").join(" ");
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        };
        res.end(JSON.stringify(await Category.findOne({where: condition}), null, 2));
    });
}
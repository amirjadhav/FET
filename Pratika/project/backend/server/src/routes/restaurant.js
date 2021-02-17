module.exports = function(app, Restaurant) {

    //get all restaurant data
    app.get('/restaurant', async (req, res) => {
        res.end(JSON.stringify(await Restaurant.findAll(), null, 2));
    });

     //get specific restaurant data
    app.get('/restaurant/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["rid"] = req.params.value;
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        };
        res.end(JSON.stringify(await Restaurant.findOne({where: condition}), null, 2));
    });
}
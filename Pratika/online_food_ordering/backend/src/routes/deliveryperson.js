const express = require("express")
const deliveryPersons = express.Router()
const cors = require("cors")
const jwt = require("jsonwebtoken")
const bcrypt = require("bcrypt")
deliveryPersons.use(cors())

process.env.SECRET_KEY = 'Sharingan'

   //find all delivery Persion
module.exports = function (app, DeliveryPerson) {
    app.get('/deliveryPerson', async (req, res) => {
        res.end(JSON.stringify(await DeliveryPerson.findAll({
            attributes: ['did', 'username', 'contact', 'vehicleno', 'address', 'email', 'rating']
        }), null, 2));
    });

//find specific delivery person using key value pair
    app.get('/deliveryPerson/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["did"] = req.params.value;
                break;
            case "username":
                condition["username"] = req.params.value.split("-").join(" ");
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        }
        res.end(JSON.stringify(await DeliveryPerson.findOne({
            attributes: ['did', 'username', 'contact', 'vehicleno', 'address', 'email', 'rating'],
            where: condition
        }), null, 2));
    });

      //Update address of deliveryPerson
     app.put('/deliveryPerson/:id', async (req, res) => {
        var order = req.body;
        console.log(order);
        res.end(JSON.stringify(await DeliveryPerson.update(order, {where: {did: req.params.id}}) ,null ,2));
     });

    //Delivery Person signup
    app.post('/deliveryPerson/register', async (req, res) => {
        const deliveryPersonData = {
            username: req.body.username,
            contact: req.body.contact,
            vehicleno: req.body.vehicleno,
            address: req. body. address,
            password: req.body. password,
            email: req.body.email

        }
        DeliveryPerson.findOne({
                where: {
                    email: req.body.email
                }
            })
            .then(deliveryPerson => {
                if (!deliveryPerson) {
                    const hash = bcrypt.hashSync(deliveryPersonData.password, 10)
                    deliveryPersonData.password = hash
                    DeliveryPerson.create(deliveryPersonData)
                        .then(element => {
                            let token = jwt.sign(element.dataValues, process.env.SECRET_KEY, {
                                expiresIn: 1440
                            })
                            res.json({
                                token: token,
                                status: 1,
                                id: element.dataValues.did,
                                email:element.dataValues.email
                            })
                        })
                        .catch(err => {
                            res.send({
                                error: err
                            })
                        })
                } else {
                    res.json({
                        error: 'Delivery Person already exists'
                    })
                }
            })
            .catch(err => {
                res.send({
                    error: err
                })
            })
    });


    //Update rating of deliveryPerson
    app.put('/deliveryPerson/rating/:id', async (req, res)=> {
        var deliveryperson = req.body.drating;
        await DeliveryPerson.findByPk(req.params.id)
        .then( (deliveryRating)=>{
            res.end(JSON.stringify( deliveryRating.update({
                rating: deliveryperson
            }) ,null ,2));
        })
    });

    //Delivery Person Login
    app.post('/deliveryPerson/login',(req, res)=>{
        DeliveryPerson.findOne({
            where:{
                email: req.body.email
            }
        })
        .then(deliveryPerson =>{
            console.log(deliveryPerson);
            if(bcrypt.compareSync(req.body.password, deliveryPerson.password)){
                let token =jwt.sign(deliveryPerson.dataValues, process.env.SECRET_KEY,{
                    expiresIn: 1440
                })
                res.json({token: token,
                    status:1,
                    id:deliveryPerson.dataValues.did,
                    username:deliveryPerson.dataValues.username
                })
            }else{
                res.send({error: 'Incorrect Crediential'})
            }
        })
        .catch(err =>{
            res.send({error: err})
        })
    })
}
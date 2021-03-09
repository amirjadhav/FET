const express = require("express")
const users = express.Router()
const cors = require("cors")
const jwt = require("jsonwebtoken")
const bcrypt = require("bcrypt")

users.use(cors())

process.env.SECRET_KEY = 'Rasengan'

module.exports = function(app, User, Address) {

    //User Signup

    app.post('/user/register', async (req, res) => {
        const userData = {
            username : req.body.username,
            email : req.body.email,
            password : req.body.password,
            phone : req.body.phone
        }
        User.findOne({
            where: {
                email:req.body.email
            }
        })
        .then(user =>{
            if(!user) {
                const hash = bcrypt.hashSync(userData.password,10)
                userData.password = hash
                User.create(userData)
                    .then(element => {
                        let token =jwt.sign(element.dataValues, process.env.SECRET_KEY, {
                            expiresIn: 1440
                        })
                        res.json({token: token,status:1,id:element.dataValues.userid})
                    })
                    .catch(err =>{
                        res.send({error: err})
                    })
            } else{
                res.json({error: 'User already exists'})
            }
        })
        .catch(err =>{
            res.send({error: err})
        })
    }); 


    //Login
    app.post('/user/login',(req, res)=>{
        User.findOne({
            where:{
                email: req.body.email
            }
        })
        .then(user =>{
            if(bcrypt.compareSync(req.body.password, user.password)){
                let token =jwt.sign(user.dataValues, process.env.SECRET_KEY,{
                    expiresIn: 1440
                })
                res.json({token: token,status:1,id:user.dataValues.userid,username:user.dataValues.username})
            }else{
                res.send({error: 'Incorrect Crediential'})
            }
        })
        .catch(err =>{
            res.send({error: err})
        })
    })

     //find all users
    app.get('/user', async (req, res) => {
        res.end(JSON.stringify(await User.findAll({
            attributes: ['userid', 'username', 'email', 'phone', 'image'],
            include: [{
                model: Address,
                as: "address",
                attributes: ["id","type", "address", "longitude", "latitude"]
            }]
        }), null, 2));
    });

    //find specific user using key value pair
    app.get('/user/:key/:value', async (req, res) => {
        var condition = {};
        switch (req.params.key) {
            case "id":
                condition["userid"] = req.params.value;
                break;
            case "name":
                condition["username"] = req.params.value.split("-").join(" ");
                break;
            default:
                condition[req.params.key] = req.params.value.split("-").join(" ");
        }
        res.end(JSON.stringify(await User.findOne({
            attributes: ['userid', 'username', 'email', 'phone', 'image'],
            include: [{
                model: Address,
                as: "address",
                attributes: ["id","type", "address", "longitude", "latitude"]
            }],
            where: condition
        }), null, 2));
    });

    app.put('/user/:id', async (req, res)=> 
    {
       var user = req.body;
        console.log(user)
        
            res.end(JSON.stringify(await User.update(user, {where: {userid: req.params.id}})
               
            ,null ,2));
    });
}
const express = require("express");
const cors = require('cors');
const bodyParser = require('body-parser');
const db = require('./src/database/connection');
const app = express();
const port = 7200;
const nodemailer = require("nodemailer");

app.use(cors());
app.use(bodyParser.json());

require("./src/routes/user")(app, db.user, db.address);
require("./src/routes/category")(app, db.category);
require("./src/routes/address")(app, db.user, db.address);
require("./src/routes/deliveryPerson")(app, db.deliveryPerson);
require('./src/routes/menu')(app, db.menu, db.category);
require("./src/routes/restaurant")(app, db.restaurant);
require("./src/routes/orders")(app,db.orders, db.orderitems, db.menu);
require("./src/routes/orderitems")(app, db.orderitems, db.orders);
require("./src/routes/orders")(app, db.restaurant, db.orders);
require("./src/routes/sendOTP")(app, nodemailer);

app.listen(port, () => {});



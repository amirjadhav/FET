const Sequelize = require('sequelize');

var sequelize = new Sequelize('fooddelievery', 'root', 'root', {
    host: 'localhost',
    dialect: 'mysql',
  
    pool: {
        max: 5,
        min: 0,
        idle: 10000
    },
    define: {
        timestamps: false,
        freezeTableName: true
    }
});

db = {};
db.sequelize = sequelize;
db.Sequelize = Sequelize;

// Model creation
db.category = require('../models/Category')(sequelize, Sequelize);
db.user = require('../models/User')(sequelize, Sequelize);
db.address = require('../models/Address')(sequelize, Sequelize);
db.deliveryPerson = require('../models/DeliveryPerson')(sequelize, Sequelize);
db.menu = require('../models/Menu')(sequelize,Sequelize);
db.orderitems = require('../models/Orderitems')(sequelize, Sequelize);
db.orders = require('../models/Orders')(sequelize, Sequelize);
db.restaurant = require('../models/Restaurant')(sequelize, Sequelize);

// Foreign key declaration for address table
//user and address table relation
db.user.hasMany(db.address, {
    foreignKey: "userid",
    as: "address"
});
db.address.belongsTo(db.user, {
    foreignKey: "userid"
});

//menu and category table relation
db.menu.hasOne(db.category,{
    foreignKey:"cid",
    sourceKey:"cid",
    as:"category"
});
db.category.belongsTo(db.menu,{
       foreignKey:"cid"
});

//orders and orderitems table relation
db.orders.hasMany(db.orderitems, {
    foreignKey: "oid",
    sourceKey: "oid",
    as: "items"
});
db.orderitems.belongsTo(db.orders, {
    foreignKey: "oid"
});

//orderitems and menu table relation
db.orderitems.hasOne(db.menu, {
    foreignKey: "mid",
    sourceKey: "mid",
    as: "menu"
});
db.menu.belongsTo(db.orderitems, {
    foreignKey: "mid"
});

module.exports = db;
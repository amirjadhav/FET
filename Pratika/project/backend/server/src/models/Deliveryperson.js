//delivery person module
module.exports = (sequelize, Sequelize) =>{
const DeliveryPersons =sequelize.define("deliveryPerson",
{
    did: {    
         primaryKey:true,
        allowNull:false,
        type:Sequelize.INTEGER(11),
    },
    name:Sequelize.STRING,
    contact:Sequelize.BIGINT,
    vehicleno:Sequelize.STRING,
    address:Sequelize.STRING,
    username:Sequelize.STRING,
    password:Sequelize.STRING,
    email:Sequelize.STRING,
    rating:Sequelize.FLOAT  
});
return DeliveryPersons;
}

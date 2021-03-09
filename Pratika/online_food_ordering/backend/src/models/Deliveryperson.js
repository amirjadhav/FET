//delivery person module
module.exports = (sequelize, Sequelize) =>{
const DeliveryPersons =sequelize.define("deliveryPerson",
{
    did: {    
         primaryKey:true,
        allowNull:false,
        autoIncrement: true,
        type:Sequelize.INTEGER(11),
    },
    username:Sequelize.STRING,
    contact:Sequelize.BIGINT,
    vehicleno:Sequelize.STRING,
    address:Sequelize.STRING,
    password:Sequelize.STRING,
    email:Sequelize.STRING,
    rating:Sequelize.FLOAT  
});
return DeliveryPersons;
}

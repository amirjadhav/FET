module.exports = (sequelize, Sequelize) => {

    var Restaurant = sequelize.define('restaurant', {
        rid:{
            type: Sequelize.INTEGER,
            allowNull: false,
            primaryKey: true,
            autoIncrement: true
        },
        name:{
            type: Sequelize.STRING(100)
        },
        address:{
            type: Sequelize.STRING(255)
        },
        foodtype:{
            type: Sequelize.ENUM('Veg', 'Veg/Non-Veg')
        },
        contact:{
            type: Sequelize.BIGINT(15)
        },
        description:{ 
            type: Sequelize.STRING(1024)
        },
        longitude:{
            type: Sequelize.DOUBLE
        },
        latitude:{
            type: Sequelize.DOUBLE
        },
        starttime:{
            type: Sequelize.STRING(10)
        },
        endtime:{
            type: Sequelize.STRING(10)
        },
        rating:{
            type: Sequelize.FLOAT
        },
        image:{
            type: Sequelize.STRING(255)
        },
        perperson:{
            type: Sequelize.INTEGER
        }
    });

    return Restaurant;
}
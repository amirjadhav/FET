module.exports = (sequelize, Sequelize) => {
    const Orders=sequelize.define("orders",{
        oid:{
            type:Sequelize.INTEGER,
            primaryKey:true,
            allowNull:false,
            autoIncrement: true
        },
        uid:{
            type:Sequelize.INTEGER
        },
        rid:{
            type:Sequelize.INTEGER
        },
        did:{
            type:Sequelize.INTEGER
        },
        ordertime:{
            type:Sequelize.STRING(10)
    
        }, 
        orderdate:{
            type:Sequelize.DATE
        },
        price:{
            type:Sequelize.FLOAT
        },
        address:{
            type:Sequelize.STRING(255)
        },
        longitude:{
            type:Sequelize.DOUBLE
        },
        latitude:{
            type:Sequelize.DOUBLE
        },
        status:{
            type:Sequelize.STRING(50)
        },
        rrating:{
            type:Sequelize.INTEGER
        },
        drating:{
            type:Sequelize.INTEGER
        },
        otp:{
            type:Sequelize.BIGINT
        }
    
    });
    return Orders
  }

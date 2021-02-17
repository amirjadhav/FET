

module.exports = (sequelize, Sequelize )=> {

const Menu=sequelize.define("menu",
{
    mid:{    
        primaryKey:true,
        allowNull:false,
        autoIncrement: true,
        type:Sequelize.INTEGER,
        },
   
    cid:{
       type: Sequelize.INTEGER,

     
    },

    restid:{ 
        type:Sequelize.INTEGER
    },
    itemname:{
        type:Sequelize.STRING
    },
    price:{
        type:Sequelize.DOUBLE
    },
    foodtype:{
        type:Sequelize.ENUM('Veg','Non-Veg')
    },
    img:{
        type:Sequelize.STRING
    }

});

// don't add the timestamp attributes (updatedAt, createdAt)
// your other configuration here
  return Menu;
// menu.belongTo(category,{foreignKey:'cid'});
// menu.belongTo(restaurant,{foreignKey:'rid'});


}



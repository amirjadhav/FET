module.exports = (sequelize, Sequelize) => {
  const OrderItems = sequelize.define("orderitems",
  {
      srno:{    
           primaryKey:true,
          allowNull:false,
          autoIncrement: true,
          type:Sequelize.INTEGER
          },
      oid:{
        type: Sequelize.INTEGER
      },
      mid:{
        type: Sequelize.INTEGER
      },
      quantity:{
        type: Sequelize.INTEGER
      },
      price:{
        type: Sequelize.DOUBLE
      }  
   
  });
  return OrderItems
}

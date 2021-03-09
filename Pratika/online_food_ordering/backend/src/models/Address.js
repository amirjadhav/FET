module.exports = (sequelize, Sequelize) => {
    const Address = sequelize.define("address",
    {
        id: {    
            primaryKey: true,
            allowNull: false,
            type: Sequelize.INTEGER,
            autoIncrement: true
        },
        userid: Sequelize.INTEGER,
        type: Sequelize.STRING,
        address: Sequelize.STRING,
        longitude: Sequelize.DOUBLE,
        latitude: Sequelize.DOUBLE
    });
    return Address;
}
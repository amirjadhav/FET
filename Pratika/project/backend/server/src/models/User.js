module.exports = (sequelize, Sequelize) => {
    const Users = sequelize.define("user",
    {
        userid: {    
            primaryKey: true,
            allowNull: false,
            autoIncrement: true,
            type: Sequelize.INTEGER(11),
        },
        username: Sequelize.STRING,
        email: Sequelize.STRING,
        password: Sequelize.STRING,
        phone: Sequelize.BIGINT,
        image: Sequelize.STRING
    });
    return Users
}
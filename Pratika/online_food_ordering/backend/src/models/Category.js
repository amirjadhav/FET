module.exports = (sequelize, Sequelize) => {
    var Category = sequelize.define('category', {
        cid: {
            type: Sequelize.INTEGER,
            allowNull: false,
            primaryKey: true,
            autoIncrement: true
        },
        cname: {
            type: Sequelize.STRING(100)
        }
    });
    return Category;
}
package dao.mySQLDAO;

import Entities.Product;
import InterfacesDao.ProductDAO;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ProductDAOMySQL implements ProductDAO<SQLException> {


    @Override
    public void insertAll(LinkedList<Product> products) throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("INSERT INTO Product (idProduct, name, value) VALUES(?,?,?)");
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Product (idProduct, name, value) VALUES(?,?,?)");
        products.forEach(product -> {
            try {
                preparedStatement.setInt(1,product.getIdProduct());
                preparedStatement.setString(2,product.getName());
                preparedStatement.setFloat(3,product.getValue());
                preparedStatement.addBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.executeBatch();
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void createTable() throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        //Only for testing: Disable the foreing key checks to allow drop table
        conn.prepareStatement("SET foreign_key_checks = 0;").execute();
        conn.prepareStatement("DROP TABLE IF EXISTS Product").execute();
        conn.prepareStatement("SET foreign_key_checks = 1;");
        conn.commit();
        conn.prepareStatement("CREATE TABLE Product (idProduct int PRIMARY KEY , " +
                " name varchar(45) NOT NULL," +
                " value float NOT NULL)" ).execute();
        conn.commit();
        conn.close();
    }

    @Override
    public Product productMoreCollects() throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        Product p = null;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT p.idProduct, p.name, p.value, SUM(p.value*bp.quantity) as Recaudacion" +
                                                            " FROM Product p JOIN BillProduct bp ON p.idProduct=bp.idProduct" +
                                                            " GROUP BY idProduct, name, value" +
                                                            " ORDER BY Recaudacion DESC" +
                                                            " LIMIT 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3));
            }
            conn.commit();
            conn.close();
            return p;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return p;

    }
}

package dao.mySQLDAO;

import Entities.BillProduct;
import InterfacesDao.BillProductDAO;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class BillProductDAOMySQL implements BillProductDAO<SQLException> {

    @Override
    public void insertAll(LinkedList<BillProduct> billProducts) throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("INSERT INTO BillProduct (idBill, idProduct, quantity) VALUES(?,?,?)");
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO BillProduct (idBill, idProduct, quantity) VALUES(?,?,?)");
        billProducts.forEach(billProduct -> {
            try {
                preparedStatement.setInt(1,billProduct.getIdBill());
                preparedStatement.setInt(2,billProduct.getIdProduct());
                preparedStatement.setInt(3,billProduct.getQuantity());
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
        conn.prepareStatement("SET foreign_key_checks = 0;").execute();
        conn.prepareStatement("DROP TABLE IF EXISTS BillProduct").execute();
        conn.prepareStatement("SET foreign_key_checks = 1;").execute();
        conn.commit();
        conn.prepareStatement("CREATE TABLE BillProduct (idBill integer NOT NULL , " +
                "idProduct integer NOT NULL," +
                " quantity integer NOT NULL," +
                " PRIMARY KEY (idBill, idProduct)," +
                " FOREIGN KEY (idBill) REFERENCES Bill (idBill)," +
                " FOREIGN KEY (idProduct) REFERENCES Product (idProduct)" +
                "ON DELETE CASCADE)").execute();
        conn.commit();
        conn.close();
    }
}

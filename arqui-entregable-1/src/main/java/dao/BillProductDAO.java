package dao;

import Entities.BillProduct;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class BillProductDAO implements InterfacesDao.BillProductDAO {


    @Override
    public void insertAll(LinkedList<BillProduct> billProducts) throws SQLException {
        this.createBillProductTable();
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
    public void createBillProductTable() throws SQLException {
        MySQLDAOFactory.setURI("jdbc:mysql://localhost:13306/arqui");
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("DROP TABLE IF EXISTS BillProduct").execute();
        conn.commit();
        conn.prepareStatement("CREATE TABLE BillProduct (idBill integer NOT NULL , " +
                "idProduct integer NOT NULL," +
                " cantidad integer NOT NULL," +
                " PRIMARY KEY (idBill, idProduct))," +
                " FOREIGN KEY idBill REFERENCES Bill (idBill)," +
                " FOREIGN KEY idProduct REFERENCES Product (idProduct)").execute();
        conn.commit();
        conn.close();
    }
}

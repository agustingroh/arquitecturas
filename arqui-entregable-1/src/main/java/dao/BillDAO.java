package dao;

import Entities.Bill;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class BillDAO implements InterfacesDao.BillDAO {

    private String uri;

    public BillDAO (String uri) {
        this.uri = uri;
    }
    @Override
    public void insertAll(LinkedList<Bill> bills) throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Bill (idBill, idClient) VALUES(?,?)");
        bills.forEach(bill -> {
            try {
                preparedStatement.setInt(1,bill.getIdBill());
                preparedStatement.setInt(2,bill.getIdClient());
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
        MySQLDAOFactory.setURI(this.uri);
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("DROP TABLE IF EXISTS Bill").execute();
        conn.commit();
        conn.prepareStatement("CREATE TABLE Bill (idBill INT PRIMARY KEY , idClient INT NOT NULL, FOREIGN KEY (idClient) REFERENCES Client (id))").execute();
        conn.commit();
        conn.close();

    }
}

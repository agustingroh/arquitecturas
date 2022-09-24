package dao.mySQLDAO;

import Entities.Bill;
import InterfacesDao.BillDAO;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class BillDAOMYSQL implements BillDAO<SQLException> {

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
        Connection conn = MySQLDAOFactory.createConnection();
        //Only for testing: Disable the foreing key checks to allow drop table
        conn.prepareStatement("SET foreign_key_checks = 0;").execute();
        conn.prepareStatement("DROP TABLE IF EXISTS Bill").execute();
        conn.prepareStatement("SET foreign_key_checks = 1;").execute();
        conn.commit();
        conn.prepareStatement("CREATE TABLE Bill (idBill INT PRIMARY KEY , idClient INT NOT NULL, FOREIGN KEY (idClient) REFERENCES Client (id)" +
                "ON DELETE CASCADE)").execute();
        conn.commit();
        conn.close();

    }
}

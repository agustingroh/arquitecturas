package dao;

import Entities.Client;
import InterfacesDao.ClientDAO;
import daoFactory.MySQLDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author Ana Celani, Pedro Codan, Agustin Groh
 * **/

public class ClientDAOMySQL implements ClientDAO {

/**
 * @brief Creates client table on database only if exists
 * @return SQLException if something goes wrong on the creation
 * **/
    public void createClientTable() throws SQLException {
        //rever uri por parametro
        //Una clase por db?
        MySQLDAOFactory.setURI("jdbc:mysql://localhost:13306/arqui");
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("DROP TABLE IF EXISTS Client").execute();
        conn.commit();
        conn.prepareStatement("CREATE TABLE Client (id integer PRIMARY KEY , nombre VARCHAR(50) NOT NULL, email VARCHAR(150) NOT NULL)").execute();
        conn.commit();
        conn.close();

    }


    /**
     * @brief Insert a list of clients on the database
     * @param clients List of clients
     * **/
    public void insertAll(LinkedList<Client> clients) throws SQLException {
        this.createClientTable();
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("INSERT INTO Client (id,nombre,email) VALUES(?,?,?)");
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Client (id,nombre,email) VALUES(?,?,?)");
      clients.forEach(client -> {
          try {
              preparedStatement.setInt(1,client.getId());
              preparedStatement.setString(2,client.getName());
              preparedStatement.setString(3,client.getMail());
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
}

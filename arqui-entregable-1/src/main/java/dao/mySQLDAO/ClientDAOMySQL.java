package dao.mySQLDAO;
import Entities.Client;
import InterfacesDao.ClientDAO;
import daoFactory.MySQLDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Ana Celani, Pedro Codan, Agustin Groh
 * **/
public class ClientDAOMySQL implements ClientDAO<SQLException> {

    public ClientDAOMySQL () {
    }

/**
 * @brief Creates client table on database only if exists
 * @return SQLException if something goes wrong on the creation
 * **/
    @Override
    public void createTable() throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        //Only for testing: Disable the foreing key checks to allow drop table
        conn.prepareStatement("SET foreign_key_checks = 0;").execute();
        conn.prepareStatement("DROP TABLE IF EXISTS Client").execute();
        conn.prepareStatement("SET foreign_key_checks = 1;");
        conn.commit();
        conn.prepareStatement("CREATE TABLE Client (id INT PRIMARY KEY , name VARCHAR(50) NOT NULL, email VARCHAR(150) NOT NULL)").execute();
        conn.commit();
        conn.close();
    }

    /**
     * @brief lista los clientes ordenados en base a la facturacion
     * @return ArrayList<Client> ordenados por facturacion desc
     * @throws SQLException
     */
    @Override
    public ArrayList<Client> customerInvoicesMost() throws SQLException {
        ArrayList<Client> clientes = new ArrayList<>();
        Connection conn = MySQLDAOFactory.createConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT c.id, c.name, c.email, SUM(bp.quantity*p.value) as Facturacion " +
                    "FROM Client c JOIN Bill b ON c.id = b.idClient JOIN BillProduct bp ON b.idBill = bp.idBill " +
                    "JOIN Product p ON p.idProduct = bp.idProduct " +
                    "GROUP BY c.id, c.name, c.email " +
                    "ORDER BY Facturacion DESC;\n");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
                clientes.add(c);
            }
            conn.commit();
            conn.close();
            return clientes;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }


    /**
     * @brief Insert a list of clients on the database
     * @param clients List of clients
     * **/
    public void insertAll(LinkedList<Client> clients) throws SQLException {
        Connection conn = MySQLDAOFactory.createConnection();
        conn.prepareStatement("INSERT INTO Client (id,name,email) VALUES(?,?,?)");
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Client (id,name,email) VALUES(?,?,?)");
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

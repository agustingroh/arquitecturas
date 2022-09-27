package daoFactory;
import InterfacesDao.ClientDAO;
import dao.mySQLDAO.BillDAOMYSQL;
import dao.mySQLDAO.BillProductDAOMySQL;
import dao.mySQLDAO.ClientDAOMySQL;
import dao.mySQLDAO.ProductDAOMySQL;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* @author Ana Celani, Pedro Codan, Agustin Groh
* @version 0.0.1
* @brief Creates DAO Factory for SQL
**/

public class MySQLDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URI;

    public MySQLDAOFactory(String uri)
    {
       setURI(uri);
      registerDriver();
    }

    public static void setURI(String uri){
        URI=uri;
    }

    /**
     * @brief Register a jdbc driver for mySQL
     **/
    public static void registerDriver(){
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
      @brief create a connection to the database using URI,user and password.
     */
    public static Connection createConnection() throws SQLException {
        Connection conn  = DriverManager.getConnection(URI,"root","password");
        conn.setAutoCommit(false);
        return conn;
    }

    public static void createDatabase(String dbName) throws SQLException {
        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
        conn.setAutoCommit(false);
        String sql = "CREATE DATABASE IF NOT EXISTS" + " " +  dbName;
        conn.prepareStatement(sql).execute();
        conn.close();
    }

    @Override
    public ClientDAO getClientDAO() throws SQLException {
        return new ClientDAOMySQL();
    }

    @Override
    public BillDAOMYSQL getBillDAO() throws SQLException {
        return new BillDAOMYSQL();
    }

    @Override
    public BillProductDAOMySQL getBillProductDAO() throws SQLException {
        return new BillProductDAOMySQL();
    }

    @Override
    public ProductDAOMySQL getProductDAO() throws SQLException {
        return new ProductDAOMySQL();
    }

}

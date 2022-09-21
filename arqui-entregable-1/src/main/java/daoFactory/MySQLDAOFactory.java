package daoFactory;
import InterfacesDao.ClientDAO;
import dao.*;

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

    public static String URI = "";

    //Pedro: harían falta los dos parametros private cuando tenemos los dos static?
    private String uri;

    private String driver;

    private static Connection conn;

    public MySQLDAOFactory(){
      registerDriver();
    }

    /**
     * @brief Register a jdbc driver for mySQL
     **/
    public static void registerDriver(){
        try {
            //Pedro: getDeclaredConstructor funciona como un singleton no?
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
    //FIXME: Deberiamos pasar la URI el PASS Y el USR por parametro?
    public static Connection createConnection() throws SQLException {
        conn = DriverManager.getConnection(URI,"root","Password");
        conn.setAutoCommit(false);
        return conn;
    }

    /**
     * @breif Used to set the URI for connecting the database
     * @param uri where database is allocated
     * **/
    public static void setURI(String uri) {
        URI = uri;
    }

    @Override
    public ClientDAO getClientDAO() throws SQLException {
        return new ClientDAOMySQL();
    }

    @Override
    public  BillDAO getBillDAO() throws SQLException {
        return new BillDAO();
    }

    @Override
    public  BillProductDAO getBillProductDAO() throws SQLException {
        return new BillProductDAO();
    }

    @Override
    public ProductDAO getProductDAO() throws SQLException {
        return new ProductDAO();
    }

    @Override
    public void setUri(String uri) {

    }

    public String getUri(){
        return  this.uri;
    }

    public void setDriver(String driver){
        this.driver= driver;
    }


}

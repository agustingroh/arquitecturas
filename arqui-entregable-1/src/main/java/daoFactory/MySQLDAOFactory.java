package daoFactory;
import dao.BillDAO;
import dao.BillProductDAO;
import dao.ClientDAO;
import dao.ProductDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String URI = "";

    private static Connection conn;

    public MySQLDAOFactory(){
      registerDriver();
    }

    public static void registerDriver(){
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //FIXME: Deberiamos pasar la URI el PASS Y el USR por parametro?
    public static Connection createConnection() throws SQLException {
        conn = DriverManager.getConnection(URI,"root","Password");
        conn.setAutoCommit(false);
        return conn;
    }

    //"jdbc:mysql://localhost:13306/arqui"

    public static void setURI(String uri) {
        URI = uri;
    }

    @Override
    public ClientDAO getClientDAO() throws SQLException {
        return new ClientDAO();
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
    
}

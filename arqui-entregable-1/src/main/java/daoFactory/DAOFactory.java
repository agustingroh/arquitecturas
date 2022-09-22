package daoFactory;

import dao.BillDAO;
import dao.BillProductDAO;
import InterfacesDao.ClientDAO;
import dao.ProductDAO;

import java.sql.SQLException;

public abstract class DAOFactory {

    public abstract ClientDAO getClientDAO() throws SQLException;
    public abstract BillDAO getBillDAO() throws SQLException;
    public abstract BillProductDAO getBillProductDAO() throws SQLException;
    public abstract ProductDAO getProductDAO() throws SQLException;


    public static DAOFactory getDAOFactory(Databases databases,String uri) {
        switch (databases) {
            case MYSQL : return new MySQLDAOFactory(uri);
            case DERBY: return null;
            case POSTGRESQL: return null;
            default: return null;
        }
    }


}

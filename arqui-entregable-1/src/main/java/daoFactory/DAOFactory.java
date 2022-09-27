package daoFactory;

import dao.mySQLDAO.BillDAOMYSQL;
import dao.mySQLDAO.BillProductDAOMySQL;
import InterfacesDao.ClientDAO;
import dao.mySQLDAO.ProductDAOMySQL;

import java.sql.SQLException;

public abstract class DAOFactory {

    public abstract ClientDAO getClientDAO() throws Throwable;
    public abstract BillDAOMYSQL getBillDAO() throws SQLException;
    public abstract BillProductDAOMySQL getBillProductDAO() throws SQLException;
    public abstract ProductDAOMySQL getProductDAO() throws SQLException;



    public static DAOFactory getDAOFactory(Databases databases,String uri) {
        switch (databases) {
            case MYSQL : return new MySQLDAOFactory(uri);
            case DERBY: return null;
            case POSTGRESQL: return null;
            default: return null;
        }
    }


}

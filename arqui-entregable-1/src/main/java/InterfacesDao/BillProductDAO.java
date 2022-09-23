package InterfacesDao;

import Entities.BillProduct;
import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;
public interface BillProductDAO {
    public void insertAll(LinkedList<BillProduct> billProducts) throws SQLException;
    public void createTable() throws SQLException;
}

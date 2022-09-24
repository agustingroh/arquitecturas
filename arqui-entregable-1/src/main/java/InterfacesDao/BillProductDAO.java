package InterfacesDao;

import Entities.BillProduct;
import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;
public interface BillProductDAO<T extends Throwable> {
    public void insertAll(LinkedList<BillProduct> billProducts) throws T;
    public void createTable() throws T;
}

package InterfacesDao;

import Entities.Bill;
import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;

public interface BillDAO<T extends Throwable> {
    public void insertAll(LinkedList<Bill> bills) throws T;
    public void createTable() throws T;
}

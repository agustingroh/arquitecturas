package InterfacesDao;

import Entities.Bill;
import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;

public interface BillDAO {
    public void insertAll(LinkedList<Bill> bills) throws SQLException;
    public void createBillTable() throws SQLException;
}

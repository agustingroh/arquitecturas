package InterfacesDao;

import Entities.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ClientDAO {
    public void insertAll(LinkedList<Client> clients) throws SQLException;
    public void createClientTable() throws SQLException;
    public ArrayList<Client> customerInvoicesMost() throws SQLException;

}

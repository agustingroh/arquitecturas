package InterfacesDao;

import Entities.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ClientDAO <T extends Throwable> {
    public void insertAll(LinkedList<Client> clients) throws T;
    void createTable() throws T ;
    public ArrayList<Client> customerInvoicesMost() throws T;

}

package InterfacesDao;

import Entities.Client;
import Entities.Product;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ProductDAO <T extends Throwable>{
    public void insertAll(LinkedList<Product> products) throws T;
    public void createTable() throws T;
    public Product productMoreCollects() throws T;
}

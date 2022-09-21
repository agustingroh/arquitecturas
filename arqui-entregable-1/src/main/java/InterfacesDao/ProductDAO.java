package InterfacesDao;

import Entities.Client;
import Entities.Product;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ProductDAO {
    public void insertAll(LinkedList<Product> products) throws SQLException;
    public void createProductTable() throws SQLException;

    public Product productMoreCollects() throws SQLException;
}

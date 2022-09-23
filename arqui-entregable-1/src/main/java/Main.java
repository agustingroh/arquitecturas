import Entities.Bill;
import Entities.BillProduct;
import Entities.Client;
import Entities.Product;
import InterfacesDao.BillDAO;
import InterfacesDao.BillProductDAO;
import InterfacesDao.ProductDAO;
import csvReader.CSVBillProductReader;
import csvReader.CSVBillReader;
import csvReader.CSVClientReader;
import InterfacesDao.ClientDAO;
import csvReader.CSVProductReader;
import daoFactory.DAOFactory;
import daoFactory.Databases;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        // Obtenemos el DAO de mySQL
       DAOFactory mySQLDAO = DAOFactory.getDAOFactory(Databases.MYSQL,"jdbc:mysql://localhost:13306/arqui");


       // Obtenemos los DAO de cada entidad
        ClientDAO clientDAO = mySQLDAO.getClientDAO();
        BillDAO billDAO = mySQLDAO.getBillDAO();
        ProductDAO productDAO = mySQLDAO.getProductDAO();
        BillProductDAO billProductDAO = mySQLDAO.getBillProductDAO();

        // lectura de CSV's
        String filePath = new File("").getAbsolutePath();
        LinkedList<Client> clients = new CSVClientReader(filePath + "/src/main/java/csv/clientes.csv").getClients();
        LinkedList<Bill> bills = new CSVBillReader(filePath + "/src/main/java/csv/facturas.csv").getBills();
        LinkedList<Product> products = new CSVProductReader(filePath + "/src/main/java/csv/productos.csv").getProduct();
        LinkedList<BillProduct> billsProducts = new CSVBillProductReader(filePath + "/src/main/java/csv/facturas-productos.csv").getBillProduct();


        //Creamos las tablas
        clientDAO.createTable();
        billDAO.createTable();
        productDAO.createTable();
        billProductDAO.createTable();

        //insertamos los datos en las tablas
        clientDAO.insertAll(clients);
        billDAO.insertAll(bills);
        productDAO.insertAll(products);
        billProductDAO.insertAll(billsProducts);


        //Obtenemos el producto con mayor recaudacion
        System.out.println("PRODUCTO CON MAYOR FACTURACION");
        Product p = productDAO.productMoreCollects();
        System.out.println(p);


        //Obtenemos las lista de clientes ordenada con mayor facturacion
        System.out.println("LISTA DE CLIENTES ORDENADAS CON MAYOR FACTURACION");
        List <Client> c = clientDAO.customerInvoicesMost();
        c.forEach(client -> System.out.println(client));


    }
}

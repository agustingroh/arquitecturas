import Entities.Bill;
import Entities.BillProduct;
import Entities.Client;
import InterfacesDao.BillDAO;
import InterfacesDao.BillProductDAO;
import csvReader.CSVBillReader;
import csvReader.CSVClientReader;
import InterfacesDao.ClientDAO;
import daoFactory.DAOFactory;
import daoFactory.Databases;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        DAOFactory mySQLDAO = DAOFactory.getDAOFactory(Databases.MYSQL);
        mySQLDAO.setUri("jdbc:mysql://localhost:13306/arqui");
        ClientDAO clientDao = mySQLDAO.getClientDAO();
        String filePath = new File("").getAbsolutePath();
        LinkedList<Client> clients = new CSVClientReader(filePath + "/src/main/java/csv/clientes.csv").getClients();
        clientDao.insertAll(clients);

        LinkedList<Bill> bills = new CSVBillReader(filePath + "/src/main/java/csv/facturas.csv").getBills();
        bills.forEach(bill -> System.out.println(bill));
        BillDAO billDAO = mySQLDAO.getBillDAO();
        billDAO.insertAll(bills);

        // TODO: Implements  CSV BillProduct reader
        LinkedList<BillProduct> billsProducts = new CSVBill(filePath + "/src/main/java/csv/facturas.csv").getBills();
        BillProductDAO billProductDAO = mySQLDAO.getBillProductDAO();
        billProductDAO.insertAll(billsProducts);







    }
}

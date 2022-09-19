import Entities.Client;
import csvReader.CSVClientReader;
import dao.ClientDAO;
import daoFactory.DAOFactory;
import daoFactory.Databases;
import daoFactory.MySQLDAOFactory;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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




    }
}

import daoFactory.DAOFactory;
import daoFactory.Databases;
import daoFactory.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        MySQLDAOFactory.setURI("jdbc:mysql://localhost:13306/arqui");
        MySQLDAOFactory.createConnection();


    }
}

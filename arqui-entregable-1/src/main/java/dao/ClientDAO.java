package dao;

import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ClientDAO {

    public void insertAll(LinkedList<Client> clients) throws SQLException;


}

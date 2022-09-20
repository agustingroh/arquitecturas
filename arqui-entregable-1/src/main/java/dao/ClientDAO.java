package dao;

import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ClientDAO {
    //Pedro: la interface no debería ser genérica para todas las clases DAO? y plantear un
    // "public void insertAll(LinkedList<T> items) throws SQLException;"
    public void insertAll(LinkedList<Client> clients) throws SQLException;


}

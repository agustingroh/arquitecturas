package dao;

import Entities.Client;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ClientDAO {
    //Pedro: la interface no debería ser genérica para todas las clases DAO? y plantear un
    //public interface DAO{
    // public void insertAll(LinkedList<T> items) throws SQLException;
    // public void Optional<T> get(int id) throws SQLException;
    // public void List<T> getAll() throws SQLException;
    // public void void delete(T t);
    // etc...
    public void insertAll(LinkedList<Client> clients) throws SQLException;


}

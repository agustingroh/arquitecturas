package main.java.factoryEntityManager;

import main.java.repository.CareerRepository;
import main.java.repository.PersonCareerRepository;
import main.java.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public abstract class FactoryEntityManager {

    public abstract PersonRepository getPersonRepository() throws SQLException;
    public abstract CareerRepository getCareerRepository() throws SQLException;
    public abstract PersonCareerRepository getPersonCareerRepository() throws SQLException;
    protected EntityManager em;
    public FactoryEntityManager(String db){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(db);
        this.em = emf.createEntityManager();
    }
    public static  FactoryEntityManager getEntityManager(String db){
        switch (db){
            case "MYSQL": return new MySQLFactoryEntityManager(db);
            case "DERBY": return null;
            default: return null;
        }
    }
    public PersonRepository getDaoPerson(){
        return new PersonRepository(this.em);
    }
}

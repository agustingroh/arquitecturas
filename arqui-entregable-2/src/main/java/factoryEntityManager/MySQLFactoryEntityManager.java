package main.java.factoryEntityManager;

import main.java.entities.Person;
import main.java.repository.CareerRepository;
import main.java.repository.PersonCareerRepository;
import main.java.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class MySQLFactoryEntityManager extends FactoryEntityManager {

    @Override
    public PersonRepository getPersonRepository() throws SQLException {
        return new PersonRepository(this.em);
    }

    @Override
    public CareerRepository getCareerRepository() throws SQLException {
        return new CareerRepository(this.em);
    }

    @Override
    public PersonCareerRepository getPersonCareerRepository() throws SQLException {
        return new PersonCareerRepository(this.em);
    }

    public MySQLFactoryEntityManager(String db){
        super(db);
    }



}

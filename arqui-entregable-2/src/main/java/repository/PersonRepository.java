package main.java.repository;

import main.java.entities.Career;
import main.java.entities.Person;
import main.java.interfaces.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PersonRepository extends Repository implements IRepository<Person, Integer> {

    public PersonRepository(EntityManager em){
        super(em);
    }

    @Override
    public void insert(Person person){
        this.em.getTransaction().begin();
        this.em.persist(person);
        this.em.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() {
        this.em.getTransaction().begin();
        List<Person> students = em.createQuery("SELECT p FROM Person p").getResultList();
        this.em.getTransaction().commit();
        return students;
    }

    public List<Person> getStudentsOrderedBySurname(){
        this.em.getTransaction().begin();
        List<Person> students = em.createQuery("SELECT p FROM Person p ORDER BY surname").getResultList();
        this.em.getTransaction().commit();
        return students;
    }


    public Person getByLU(int LU) {
        this.em.getTransaction().begin();
        String jpql = "SELECT p FROM Person p WHERE collegeNotebook= :LU";
        Query query = em.createQuery(jpql).setParameter("LU",LU);
        Person p = (Person) query.getSingleResult();
        this.em.getTransaction().commit();
        return p;
    }

    public List<Person> getAllByGender(String gender) {
        this.em.getTransaction().begin();
        String jpql = "SELECT p FROM Person p WHERE gender LIKE:gender";
        Query query = em.createQuery(jpql).setParameter("gender",gender);
        List<Person> students =  query.getResultList();
        this.em.getTransaction().commit();
        return students;
    }

    @Override
    public Person get(Integer dni) {
        this.em.getTransaction().begin();
        String jpql = "SELECT p FROM Person p WHERE dni=:DNI";
        Query query = em.createQuery(jpql).setParameter("DNI",dni);
        Person s = (Person) query.getSingleResult();
        this.em.getTransaction().commit();
        return s;
    }

    @Override
    public void delete(Integer dni) {
        this.em.getTransaction().begin();
        this.em.createQuery("DELETE FROM Person p WHERE dni=:DNI").setParameter("DNI",dni).executeUpdate();
        this.em.getTransaction().commit();
    }


    public void register(Person person , Career career){

    }


    public void insertAll(LinkedList<Person> persons) {
        this.em.getTransaction().begin();
        persons.forEach(person -> {
             try {
                 this.em.persist(person);
             } catch (Exception e){
                 throw new RuntimeException(e);
             }
        });
        this.em.getTransaction().commit();
    }
}

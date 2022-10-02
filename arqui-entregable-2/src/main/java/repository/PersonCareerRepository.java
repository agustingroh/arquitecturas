package main.java.repository;

import main.java.entities.Person;
import main.java.entities.PersonCareer;
import main.java.interfaces.IRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class PersonCareerRepository extends Repository implements IRepository<PersonCareer,Integer> {
    public PersonCareerRepository(EntityManager em){
        super(em);
    }


    @Override
    public void insert(PersonCareer personCareer) {
        this.em.getTransaction().begin();
        this.em.persist(personCareer);
        this.em.getTransaction().commit();
    }

    @Override
    public List<PersonCareer> getAll() {
        return null;
    }

    @Override
    public PersonCareer get(Integer integer) {
        return null;
    }

    @Override
    public PersonCareer delete(Integer integer) {
        return null;
    }


    public List<Person> getStudentsByCareerFilterCity(int career_id, String city) {
        this.em.getTransaction().begin();

        @SuppressWarnings("unchecked")
        List<Person> students = this.em.createQuery("SELECT DISTINCT(p) FROM Person p, PersonCareer pc "
                        + "WHERE pc.career.id = :career "
                        + "AND p.city = :city")
                .setParameter("career", career_id)
                .setParameter("city", city)
                .getResultList();

        this.em.getTransaction().commit();

        return students;
    }
}
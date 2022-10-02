package main.java.repository;

import main.java.entities.Career;
import main.java.entities.Person;
import main.java.interfaces.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class CareerRepository extends Repository implements IRepository<Career,Integer> {

    public CareerRepository(EntityManager em){
        super(em);
    }

    @Override
    public void insert(Career career) {
        this.em.getTransaction().begin();
        this.em.persist(career);
        this.em.getTransaction().commit();
    }

    @Override
    public List<Career> getAll() {
        return null;
    }

    @Override
    public Career get(Integer id) {
        this.em.getTransaction().begin();
        String jpql = "SELECT c FROM Career c WHERE id= :id";
        Query query = em.createQuery(jpql).setParameter("id",id);
        Career c = (Career) query.getSingleResult();
        this.em.getTransaction().commit();
        return c;
    }

    @Override
    public Career delete(Integer integer) {
        return null;
    }
}

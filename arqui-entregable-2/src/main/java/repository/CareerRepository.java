package main.java.repository;

import main.java.entities.Career;
import main.java.entities.Person;
import main.java.interfaces.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

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
        this.em.getTransaction().begin();
        String jpql = "SELECT c FROM Career c";
        Query query = em.createQuery(jpql);
        List<Career> careers =  query.getResultList();
        this.em.getTransaction().commit();
        return careers;
    }

    @Override
    public Career get(Integer id) {
        this.em.getTransaction().begin();
        String jpql = "SELECT c FROM Career c WHERE id=:careerId";
        Query query = em.createQuery(jpql).setParameter("careerId",id);
        Career c = (Career) query.getSingleResult();
        this.em.getTransaction().commit();
        return c;
    }

    @Override
    public void delete(Integer id) {
        this.em.getTransaction().begin();
        em.createQuery("DELETE FROM Career c WHERE c.id=:id").setParameter("id",id).executeUpdate();
        this.em.getTransaction().commit();
    }

    public List<Career> getCareerOrderByQuantityStudent(){
        Query q = em.createQuery("SELECT DISTINCT c FROM Career c JOIN c.students s WHERE size(s) > 0 ORDER BY size(s) DESC");
        return q.getResultList();
    }

    public List<Person> getStudentsByCareerAndCity(String city,String career){
        List<Person> students = em.createQuery("SELECT  pc.student FROM Career c JOIN c.students pc WHERE pc.student.city= :city AND c.name=:career")
                .setParameter("city",city)
                .setParameter("career",career)
                .getResultList();
        return students;
    }



}

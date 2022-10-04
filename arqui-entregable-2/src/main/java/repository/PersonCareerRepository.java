package main.java.repository;

import main.java.dto.CareerDTO;
import main.java.entities.Career;
import main.java.entities.Person;
import main.java.entities.PersonCareer;
import main.java.entities.PersonCareerId;
import main.java.interfaces.IRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class PersonCareerRepository extends Repository implements IRepository<PersonCareer,Long> {
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
    public PersonCareer get(Long integer) {
        return null;
    }

    @Override
    public void delete(Long integer) {
    }


    public List<Person> getStudentsByCareerFilterCity(Long career_id, String city) {
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

    public List<CareerDTO> getReport(){
        String jpql = "SELECT a.career_id, a.name, a.year ,SUM(a.enrolled) as enrolled,SUM(a.graduated) as graduated\n" +
                "                FROM (SELECT pc.career_id,c.name, YEAR(pc.initDate) as year, COUNT(*) as enrolled, '0' as graduated\n" +
                "                FROM PersonCareer pc JOIN Career c ON c.id=pc.career_id\n" +
                "                GROUP BY pc.career_id,c.name,year\n" +
                "                UNION\n" +
                "                SELECT pc.career_id,c.name, YEAR(pc.dueDate) as year,'0' as enrolled ,COUNT(*) as graduated\n" +
                "                FROM PersonCareer pc JOIN Career c ON c.id=pc.career_id\n" +
                "                GROUP BY pc.career_id,c.name,year HAVING year IS NOT NULL) as a\n" +
                "                GROUP BY a.career_id, a.name, a.year\n" +
                "                ORDER BY a.year ASC, a.name ASC";

        Query query = em.createNativeQuery(jpql);
                List <Object[]> auxReport = query.getResultList();
        return auxReport.stream().map(r-> new CareerDTO((Integer)r[0],(String) r[1],(BigInteger) r[2],((Double) r[3]).intValue(),((Double) r[4]).intValue())).collect(Collectors.toList());

    }
}
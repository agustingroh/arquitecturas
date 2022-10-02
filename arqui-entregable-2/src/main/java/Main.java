package main.java;


import main.java.entities.Career;
import main.java.entities.Person;
import main.java.entities.PersonCareer;
import main.java.factoryEntityManager.FactoryEntityManager;
import main.java.repository.CareerRepository;
import main.java.repository.PersonCareerRepository;
import main.java.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

     FactoryEntityManager mySQL =  FactoryEntityManager.getEntityManager("MYSQL");

        PersonRepository p = mySQL.getPersonRepository();
        CareerRepository c = mySQL.getCareerRepository();
        PersonCareerRepository pc = mySQL.getPersonCareerRepository();
/*        Person student = new Person(3936787,"Pedro","Codan","M","Tandil",1);
        Person student2 = new Person(3936788,"Pedro","Coda","M","Tandil",2);
        Career tudai = new Career("Tudai",2);

        c.insert(tudai);
        Career career = c.get(1);
        student.setCareers(career);

       p.insert(student);*/
      // p.insert(student2);



       // System.out.println(career);

       List<Person> studentsBySurname =  p.getStudentsOrderedBySurname();
       System.out.println(studentsBySurname);


      // Student by LU
        Person personLU = p.getByLU(1);
        System.out.println(personLU);


        // Get students by gender
        List<Person> studentsByGender = p.getAllByGender("F");
        studentsByGender.forEach(s -> {
            System.out.println(s);
        });


        // Recuperar estudiantes de una determinada carrera, filtrado por ciudad de residencia
        System.out.println("---");
        List<Person> studentsByCityAndCareer = pc.getStudentsByCareerFilterCity(1,"Tandil");
        studentsByCityAndCareer.forEach(s ->{
            System.out.println(s);
        } );

/*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("arqui");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new Person(123456,"test");

        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
*/


    }
}

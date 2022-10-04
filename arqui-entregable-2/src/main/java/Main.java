package main.java;


import main.java.dto.CareerDTO;
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
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws SQLException {

     FactoryEntityManager mySQL =  FactoryEntityManager.getEntityManager("MYSQL");

        PersonRepository p = mySQL.getPersonRepository();
        CareerRepository c = mySQL.getCareerRepository();
        PersonCareerRepository pc = mySQL.getPersonCareerRepository();
        Person student = new Person(39367874, "Pedro", "Codan", "M", "Tandil",1, 25);
        Person student2 = new Person(3936788, "Pedro", "Coda", "M", "Tandil", 2,24);
        Person student3 = new Person(4012788,"Valeria","Alvarez","F","Rauch",3,20);

        try {
            System.out.println("INGRESANDO NUEVOS ESTUDIANTES...");
            p.insert(student);
            p.insert(student2);
            p.insert(student3);

            System.out.println("CREANDO CARRERAS...");
            Career c1 = new Career("Tudai",2);
            Career c2 = new Career("Profesorado Mat",3);
            c.insert(c1);
            c.insert(c2);


            System.out.println("******OBTENER CARRERA POR ID*********");
            Career tudai = c.get(1);
            Career profMat = c.get(2);
            System.out.println(tudai);
            System.out.println(profMat);

            System.out.println("INSCRIBIENDO ESTUDIANTES A CARRERAS...");
            pc.insert(new PersonCareer(student,tudai));
            pc.insert(new PersonCareer(student2,tudai));
            pc.insert(new PersonCareer(student,profMat));


              }catch (Exception e){
           System.out.println("El alumno ya existe en la base de datos");
        }


        System.out.println("******OBTENER CARRERAS ORDENADAS POR CANTIDAD DE ALUMNOS*********");
        c.getCareerOrderByQuantityStudent().forEach(career1 ->{System.out.println(career1);} );


        System.out.println("******ESTUDIANTES DE UNA DETERMINADA CIUDAD Y CARRERA*********");
        c.getStudentsByCareerAndCity("Tandil","Tudai").forEach(person -> {System.out.println(person);});

        System.out.println("******REPORTE DE CARRERAS*********");
        List<CareerDTO> report = pc.getReport();
        report.forEach(careerDTO -> System.out.println(careerDTO));

        System.out.println("******ESTUDIANTES ORDENADOS POR APELLIDO*********");
        List<Person> studentsBySurname =  p.getStudentsOrderedBySurname();
        System.out.println(studentsBySurname);

        System.out.println("******OBTENER ESTUDIANTE POR LIBRETA UNIVERSITARIA*********");
        Person personLU = p.getByLU(1L);
        System.out.println(personLU);

        System.out.println("******OBTENER ESTUDIANTE POR GENERO*********");
        List<Person> studentsByGender = p.getAllByGender("F");
        studentsByGender.forEach(s -> {
            System.out.println(s);
        });

        mySQL.closeConnection();
    }
}

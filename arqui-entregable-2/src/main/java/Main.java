package main.java;


import main.java.csvReader.CSVCareerReader;
import main.java.csvReader.CSVPersonCareerReader;
import main.java.csvReader.CSVPersonReader;
import main.java.dto.CareerDTO;
import main.java.entities.Career;
import main.java.entities.Person;
import main.java.entities.PersonCareer;
import main.java.factoryEntityManager.FactoryEntityManager;
import main.java.repository.CareerRepository;
import main.java.repository.PersonCareerRepository;
import main.java.repository.PersonRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

     FactoryEntityManager mySQL =  FactoryEntityManager.getEntityManager("MYSQL");

        PersonRepository p = mySQL.getPersonRepository();
        CareerRepository c = mySQL.getCareerRepository();
        PersonCareerRepository pc = mySQL.getPersonCareerRepository();
        Person student = new Person(39367874, "Pedro", "Codan", "M", "Tandil",1, 25);
        Person student2 = new Person(3936788, "Pedro", "Coda", "M", "Tandil", 2,24);
        Person student3 = new Person(4012788,"Valeria","Alvarez","F","Rauch",3,20);

        String filePath = new File("").getAbsolutePath();
        LinkedList<Person> persons = new CSVPersonReader(filePath + "/src/main/java/csv/persons.csv").getPersons();
        LinkedList<Career> careers = new CSVCareerReader(filePath + "/src/main/java/csv/careers.csv").getCareers();
        LinkedList<PersonCareer> personCareers = new CSVPersonCareerReader(filePath + "/src/main/java/csv/personCareers.csv").getPersonCareers();

        try {

            System.out.println("INGRESANDO NUEVOS ESTUDIANTES...");
            p.insertAll(persons);


            System.out.println("CREANDO CARRERAS...");

            Career c1 = new Career("Tudai",2);
            c.insertAll(careers);
            c.insert(c1);

            System.out.println("******OBTENER CARRERA POR ID*********");
            Career tudai = c.get(1);

            System.out.println(tudai);


            System.out.println("INSCRIBIENDO ESTUDIANTES A CARRERAS...");
            CSVParser parserCareerStudent = CSVFormat.DEFAULT.withHeader().parse(new FileReader(filePath + "/src/main/java/csv/personCareers.csv"));
            pc.career_studentPersistence(parserCareerStudent);


            }catch (Exception e){
           System.out.println("Datos ingresdos incorrectos");
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
        Person personLU = p.getByLU(51244);
        System.out.println(personLU);

        System.out.println("******OBTENER ESTUDIANTE POR GENERO*********");
        List<Person> studentsByGender = p.getAllByGender("Female");
        studentsByGender.forEach(s -> {
            System.out.println(s);
        });

        mySQL.closeConnection();
    }
}

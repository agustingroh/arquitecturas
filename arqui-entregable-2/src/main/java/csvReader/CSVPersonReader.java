package main.java.csvReader;

import main.java.entities.Career;
import main.java.entities.Person;
import main.java.entities.PersonCareer;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class CSVPersonReader extends csvReader {
    public CSVPersonReader(String path) {
        super(path);
    }

    public LinkedList<Person> getPersons() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<Person> students = new LinkedList<>();
        for (CSVRecord record : records) {
            int dni = Integer.parseInt(record.get(0));
            String name = (record.get(1));
            String surname = (record.get(2));
            int age = Integer.parseInt(record.get(3));
            String gender = (record.get(4));
            String city = (record.get(5));
            int collage_notebook = Integer.parseInt(record.get(6));

            students.add(new Person(dni,name,surname,gender,city,collage_notebook,age));
        }
        return students;
    }
}

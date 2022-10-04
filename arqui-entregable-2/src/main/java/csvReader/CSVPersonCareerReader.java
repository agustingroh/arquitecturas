package main.java.csvReader;

import main.java.entities.Career;
import main.java.entities.Person;
import main.java.entities.PersonCareer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.time.Year;
import java.util.Date;
import java.util.LinkedList;

public class CSVPersonCareerReader extends csvReader {
    public CSVPersonCareerReader(String path) {
        super(path);
    }

    public LinkedList<PersonCareer> getPersonCareers() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<PersonCareer> personCareers = new LinkedList<>();
        for (CSVRecord record : records) {
            //En el csv hay un primer dato en 0 como id del personCareer
            Person student = new Person (record.get(1));
            Career career = new Career(record.get(2));
            Date initDate = new Date(Integer.parseInt(record.get(3)), 0,0);
            Date dueDate = new Date(Integer.parseInt(record.get(4)), 0,0);
            personCareers.add(new PersonCareer(student,career, initDate, dueDate));
        }
        return personCareers;
    }
}

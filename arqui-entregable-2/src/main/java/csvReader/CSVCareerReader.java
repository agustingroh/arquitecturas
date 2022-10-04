package main.java.csvReader;

import main.java.entities.Career;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

public class CSVCareerReader extends csvReader {
    public CSVCareerReader(String path) {
        super(path);
    }

    public LinkedList<Career> getCareers() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<Career> careers = new LinkedList<>();
        for (CSVRecord record : records) {
            int id = Integer.parseInt(record.get(0));
            String name = record.get(1);
            int duration = Integer.parseInt(record.get(2));
            careers.add(new Career(id,name,duration));
        }
        return careers;
    }

}

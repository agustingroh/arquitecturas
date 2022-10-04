package main.java.csvReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class csvReader {
    private String path;

    public csvReader(String path){
        this.path = path;
    }
    /**
     * @brief read a CSV file
     * @return iterable of CSV record
     * **/
    public Iterable<CSVRecord> read() throws IOException {
        Reader data = new FileReader(this.path);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(data);
        return records;
    }
}

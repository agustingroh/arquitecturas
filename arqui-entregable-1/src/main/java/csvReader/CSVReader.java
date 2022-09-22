package csvReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * @author Ana Celani, Pedro Codan , Agustin Groh
 * @see <p>https://commons.apache.org/proper/commons-csv/user-guide.html</p>
 * **/
public class CSVReader {
    private String path;

    public CSVReader(String path){
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

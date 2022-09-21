package csvReader;

import Entities.Bill;
import Entities.Client;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

public class CSVBillReader extends CSVReader{

    public CSVBillReader(String path) {
        super(path);
    }
    /**
     * @brief get list of bills from a CSV file
     * @return List of bills
     * **/

    //Pedro: es muuy parecido al ClientReader, en principio se podría hacer así
    // y después tratar de hacer uno más genérico
    public LinkedList<Bill> getBills() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<Bill> bills = new LinkedList<>();
        for (CSVRecord record : records) {
            //queda en spanglish por los nombres que usa los archivos csv
            int idFactura = Integer.parseInt(record.get(0));
            int idCliente = Integer.parseInt(record.get(1));
            bills.add(new Bill(idFactura,idCliente));
        }
        return bills;
    }
}

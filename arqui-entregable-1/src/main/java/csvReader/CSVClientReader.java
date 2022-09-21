package csvReader;

import Entities.Bill;
import Entities.Client;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Ana Celani, Pedro Codan , Agustin Groh
 * **/

public class CSVClientReader extends CSVReader{

    public CSVClientReader(String pathToCSV){
        super(pathToCSV);
    }

    /**
     * @brief get list of clients from a CSV file
     * @return List of Client
     * **/
    public LinkedList<Client> getClients() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<Client> clients = new LinkedList<>();
        for (CSVRecord record : records) {
            Integer idClient = Integer.valueOf(record.get(0)); //TODO:deberia ser auto incremental el id en la db o deberiamos utilizar el id del CSV
            String name = record.get(1);
            String email = record.get(2);
            clients.add(new Client(idClient,name,email));
        }
        return clients;
    }

//    public LinkedList<Bill> getBills() throws IOException {
//        Iterable<CSVRecord> records =  this.read();
//        LinkedList<Bill> bills = new LinkedList<>();
//        for (CSVRecord record : records) {
//            //queda en spanglish por los nombres que usa los archivos csv
//            int idBill = Integer.parseInt(record.get(0));
//            int idClient = Integer.parseInt(record.get(1));
//            bills.add(new Bill(idBill, idClient));
//        }
//        return bills;
//    }
}

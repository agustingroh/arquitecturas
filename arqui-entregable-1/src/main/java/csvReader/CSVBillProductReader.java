package csvReader;

import Entities.Bill;
import Entities.BillProduct;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

public class CSVBillProductReader extends CSVReader {

    public CSVBillProductReader(String pathToCSV){
        super(pathToCSV);
    }


    public LinkedList<BillProduct> getBillProduct() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<BillProduct> billsProducts = new LinkedList<>();
        for (CSVRecord record : records) {
            int idBill = Integer.parseInt(record.get(0));
            int idProduct = Integer.parseInt(record.get(1));
            int quantity = Integer.parseInt(record.get(2));
            billsProducts.add(new BillProduct(idBill,idProduct,quantity));
        }
        return billsProducts;
    }


}

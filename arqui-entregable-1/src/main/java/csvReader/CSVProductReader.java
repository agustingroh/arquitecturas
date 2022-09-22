package csvReader;

import Entities.BillProduct;
import Entities.Product;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

public class CSVProductReader extends CSVReader {

    public CSVProductReader(String pathToCSV){
        super(pathToCSV);
    }

    public LinkedList<Product> getProduct() throws IOException {
        Iterable<CSVRecord> records =  this.read();
        LinkedList<Product> products = new LinkedList<>();
        for (CSVRecord record : records) {
            int idProduct = Integer.parseInt(record.get(0));
            String name = record.get(1);
            float value = Float.parseFloat(record.get(2));
            products.add(new Product(idProduct,name,value));
        }
        return products;
    }

}

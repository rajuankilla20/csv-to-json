package util;

import com.opencsv.CSVReader;
import model.gpod.AttributeOptionsGpod;
import model.gpod.ProductAttributeOptionsGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class ProductAttributeOptionsUtil {


    public static void buildProductAttributeOptions(Map<Integer,ProductAttributeOptionsGpod> productAttributeOptionsGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.PRODUCT_ATTRIBUTES_OPTIONS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                productAttributeOptionsGpodMap.put(Integer.parseInt(row[1]),buildProductAttributeOptions(row));
            }

        }
    }


    public static ProductAttributeOptionsGpod buildProductAttributeOptions(String[] row ){
        int p_ao_id = Integer.parseInt(row[0]); // 0-p_ao_id
        int pid = Integer.parseInt(row[1]); // 1-pid
        int atid = Integer.parseInt(row[2]); // 2-atid
        int ao_id = Integer.parseInt(row[3]); // 3-ao_id
        Date createdTimestamp = DateUtil.getDate(row[4]); // 4-created_at
        Date updatedTimestamp =null; // few values are having NULl for updated_At
        if(row[5].equalsIgnoreCase("NULL")){
            updatedTimestamp = DateUtil.getDate(row[4]); //5-updated_at
        }else{
            updatedTimestamp = DateUtil.getDate(row[5]); //5-updated_at
        }

        // int pAoId, int pId, int aId, int aoId, Date createdTimestamp, Date updatedTimestamp
       return new ProductAttributeOptionsGpod(p_ao_id,pid,atid,ao_id,createdTimestamp,updatedTimestamp);
    }
}

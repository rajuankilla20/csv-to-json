package util;

import com.opencsv.CSVReader;
import model.gpod.AttributeGpod;
import model.gpod.AttributeOptionsGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class AttributeOptionsUtil {


    public static void buildAttributeOptions(Map<Integer,AttributeOptionsGpod> attributeOptionsGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ATTRIBUTES_OPTIONS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                attributeOptionsGpodMap.put(Integer.parseInt(row[0]),buildAttributes(row));
            }

        }
    }


    public static AttributeOptionsGpod buildAttributes(String[] row ){
        int ao_id = Integer.parseInt(row[0]); // 0-ao_id
        int atid = Integer.parseInt(row[1]); // 1-atid
        String desc = row[2]; //2-title
        int weight = 0; //3-weight its NULL in DB
        Date createdTimestamp = DateUtil.getDate(row[4]); // 5-created_at
        Date updatedTimestamp = DateUtil.getDate(row[4]); //5-updated_at
        // int ao_id, int atid, String desc, int weight, Date createdTimestamp, Date updatedTimestamp
       return new AttributeOptionsGpod(ao_id,atid,desc,weight,createdTimestamp,updatedTimestamp);
    }
}

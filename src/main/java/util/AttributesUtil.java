package util;

import com.opencsv.CSVReader;
import model.gpod.AttributeGpod;
import model.gpod.BrandGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class AttributesUtil {


    public static void buildAttributes(Map<Integer,AttributeGpod> attributeGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ATTRIBUTES_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                attributeGpodMap.put(Integer.parseInt(row[0]),buildAttributes(row));
            }

        }
    }


    public static AttributeGpod buildAttributes(String[] row ){
        int id = Integer.parseInt(row[0]); // 0-atid
        String desc = row[1]; //1-title
        String type = row[4]; //2-type
        boolean isActive = (Integer.parseInt(row[5]) == 1) ? true :  false ; //6 -status
        Date createdTimestamp = DateUtil.getDate(row[6]); // 7-created_at
        Date updatedTimestamp = DateUtil.getDate(row[7]); //8-updated_at
        // int id, String desc, String type, boolean isActive, Date createdTimestamp, Date updatedTimestamp
       return new AttributeGpod(id,desc,type,isActive,createdTimestamp,updatedTimestamp);
    }
}

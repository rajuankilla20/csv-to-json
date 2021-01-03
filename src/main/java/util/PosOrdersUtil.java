package util;

import com.opencsv.CSVReader;
import model.gpod.BrandGpod;
import model.gpod.PosOrdersGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PosOrdersUtil {


    public static void buildPosOrders(Map<Integer, Set<PosOrdersGpod>> posOrdersMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.POS_ORDERS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int userId = Integer.parseInt(row[2]);
                if(posOrdersMap.containsKey(userId)){
                    Set<PosOrdersGpod> posOrdersGpodSet = posOrdersMap.get(userId);
                    posOrdersGpodSet.add(buildPosOrderGpod(row));
                    posOrdersMap.put(userId,posOrdersGpodSet);
                }else{
                    Set<PosOrdersGpod> posOrdersGpodSet = new HashSet<>();
                    posOrdersGpodSet.add(buildPosOrderGpod(row));
                    posOrdersMap.put(userId,posOrdersGpodSet);
                }
            }

        }
    }


    public static PosOrdersGpod buildPosOrderGpod(String[] row ){
        PosOrdersGpod o = new PosOrdersGpod();
        o.setId(Integer.parseInt(row[0])); // 0-id
        o.setoId(Integer.parseInt(row[1])); // 1-oid
        o.setUid(Integer.parseInt(row[2])); // 2-uid
        o.setCreatedTimestamp(DateUtil.getDate(row[3])); // 3-created_at
        o.setUpdatedTimestamp(DateUtil.getDate(row[4])); // 4-updated_at
       return o;
    }
}

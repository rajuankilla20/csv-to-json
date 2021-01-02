package util;

import com.opencsv.CSVReader;
import model.gpod.OrderStatusChangeGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderStatusChangeUtil {


    public static void buildOrderStatusChange(Map<Integer, Set<OrderStatusChangeGpod>> orderStatusChangeGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ORDER_STATUS_CHANGE_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int orderId = Integer.parseInt(row[1]);
                if(orderStatusChangeGpodMap.containsKey(orderId)){
                    Set<OrderStatusChangeGpod> changeGpodSet = orderStatusChangeGpodMap.get(orderId);
                    changeGpodSet.add(prepareOrderStatusChangeGpod(row));
                    orderStatusChangeGpodMap.put(orderId,changeGpodSet);
                }else{
                    Set<OrderStatusChangeGpod> changeGpodSet  = new HashSet<>();
                    changeGpodSet.add(prepareOrderStatusChangeGpod(row));
                    orderStatusChangeGpodMap.put(orderId,changeGpodSet);
                }

            }

        }
    }


    public static OrderStatusChangeGpod prepareOrderStatusChangeGpod(String[] row ){
        OrderStatusChangeGpod statusChangeGpod = new OrderStatusChangeGpod();
        statusChangeGpod.setOscId(Integer.parseInt(row[0])); // 0-osc_id
        statusChangeGpod.setoId(Integer.parseInt(row[1])); // 1-oid
        statusChangeGpod.setOsId(Integer.parseInt(row[2])); // 2-os_id
        statusChangeGpod.setChangesBy(row[3]); // 3-changes_by
        statusChangeGpod.setChangesById(row[4]); // 4-changes_by_id
        statusChangeGpod.setCreatedTimestamp(DateUtil.getDate(row[5]));// 5-created_at
        statusChangeGpod.setUpdatedTimestamp(DateUtil.getDate(row[6]));// 6-updated_at
       return statusChangeGpod;
    }
}


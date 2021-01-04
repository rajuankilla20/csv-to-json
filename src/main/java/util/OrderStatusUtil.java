package util;

import com.opencsv.CSVReader;
import model.gpod.OrderStatusGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class OrderStatusUtil {


    public static void buildOrderStatus(Map<Integer, OrderStatusGpod> orderStatusGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ORDER_STATUS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                OrderStatusGpod  orderStatusGpod = buildOrderStatusGpod(row);
                orderStatusGpodMap.put(orderStatusGpod.getId(), orderStatusGpod);
            }

        }
    }


    public static OrderStatusGpod buildOrderStatusGpod(String[] row ){
        OrderStatusGpod orderStatusGpod = new OrderStatusGpod();
        orderStatusGpod.setId(Integer.parseInt(row[0])); // 0-osid
        orderStatusGpod.setName(row[1]); // 1-name
        orderStatusGpod.setActive(true); // no value so setting to true
        orderStatusGpod.setCreatedTimestamp(DateUtil.getDate(row[2]));// 2-created_at
        orderStatusGpod.setUpdatedTimestamp(DateUtil.getDate(row[3]));// 3-updated_at
       return orderStatusGpod;
    }
}

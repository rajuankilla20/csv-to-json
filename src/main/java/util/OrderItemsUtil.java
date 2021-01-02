package util;

import com.opencsv.CSVReader;
import model.gpod.OrderItemsGpod;
import model.gpod.OrderStatusGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderItemsUtil {


    public static void buildOrderItems(Map<Integer, Set<OrderItemsGpod>> orderItemsGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ORDER_ITEMS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int orderId = Integer.parseInt(row[1]);

                if(orderItemsGpodMap.containsKey(orderId)){
                    Set<OrderItemsGpod> orderItemsGpodSet = orderItemsGpodMap.get(orderId);
                    orderItemsGpodSet.add(buildOrderItemsGpod(row));
                    orderItemsGpodMap.put(orderId,orderItemsGpodSet);
                }else{
                    Set<OrderItemsGpod> orderItemsGpodSet = new HashSet<>();
                    orderItemsGpodSet.add(buildOrderItemsGpod(row));
                    orderItemsGpodMap.put(orderId,orderItemsGpodSet);
                }

            }

        }
    }


    public static OrderItemsGpod buildOrderItemsGpod(String[] row ){
        OrderItemsGpod orderItemsGpod = new OrderItemsGpod();
        orderItemsGpod.setOiId(Integer.parseInt(row[0])); // 0-oi_id
        orderItemsGpod.setoId(Integer.parseInt(row[1])); // 1-oid
        orderItemsGpod.setProductId(Integer.parseInt(row[2])); // 2-pid
        orderItemsGpod.setTitle(row[3]); // 3-title
        orderItemsGpod.setProductType(row[4]); // 4-product_type
        orderItemsGpod.setQuantity(Integer.parseInt(row[6])); // 6-qty
        orderItemsGpod.setCost(Double.parseDouble(row[7])); // 7-cost
        orderItemsGpod.setSubTotal(Double.parseDouble(row[10])); // 10-sub_total
        orderItemsGpod.setSubstituteProduct(row[12]); // 12-substitute_product
        orderItemsGpod.setSubstituteQuantity(Integer.parseInt(row[13])); // 13-substitute_qty
        orderItemsGpod.setSubstitute(row[14]); // 14-substitute
        orderItemsGpod.setCreatedTimestamp(DateUtil.getDate(row[15]));// 15-created_at
        orderItemsGpod.setUpdatedTimestamp(DateUtil.getDate(row[16]));// 16-updated_at
       return orderItemsGpod;
    }
}

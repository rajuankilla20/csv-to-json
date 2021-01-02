package util;

import com.opencsv.CSVReader;
import model.gpod.OrderStatusGpod;
import model.gpod.OrdersGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class OrdersUtil {


    public static void buildOrderStatus(Map<Integer, OrdersGpod> ordersGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ORDER_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int orderId= Integer.parseInt(row[0]);
                ordersGpodMap.put(orderId, buildOrdersGpod(row));
            }

        }
    }


    public static OrdersGpod buildOrdersGpod(String[] row ){
        // NOTE : Ignored these as its not having any value and not using anywhere
//            3-"transaction_id"
//            5-"transaction_amount"
//            6-"transaction_email"
//            7-"transaction_failure_reason"
//            8-"transaction_status"

        OrdersGpod o = new OrdersGpod();
        o.setoId(Integer.parseInt(row[0]));  // 0-oid
        o.setId(Integer.parseInt(row[1]));  // 1-id
        o.setInvoiceNo(row[2]);  // 2-"invoice_no"
        o.setBillingFullName(row[4]);  // 4-"billing_full_name"
        o.setPaymentGatewayTransactionStatus(row[9]);  // 9-"payment_gateway_transaction_status"
        o.setInvoiceDate(DateUtil.getDate(row[10]));  // 10-"invoice_date"
        o.setCouponId(row[11]);  // 11-"couponid"
        o.setCouponDiscount(row[12]);  // 12-"coupon_discount"
        o.setFinalSubtotal(Double.parseDouble(row[13])); // 13-"final_subtotal"
        o.setShippingChargeNet(Double.parseDouble(row[14])); // 14-"shipping_charge_net"
        o.setTax(Double.parseDouble(row[15])); // 15-"tax"
        o.setTip(Double.parseDouble(row[16])); // 16-"tip"
        o.setTipType(row[17]);  // 17-"tip_type"
        o.setGrandTotal(Double.parseDouble(row[18])); // 18-"grand_total"
        o.setIp(row[19]);  // 19-"ip"
        o.setPaymentMethod(row[20]);  // 20-"payment_method"
        o.setPickupDate(DateUtil.getDate(row[21]));  // 21-"pickup_date"
        o.setPickupTime(row[22]);  // 22-"pickup_time"
        o.setPickupLocation(row[23]);  // 23-"pickup_location"
        o.setSubstituteOption(Integer.parseInt(row[24]));  // 24-"substitute_option"
        o.setCreatedTimestamp(DateUtil.getDate(row[25]));// 25-created_at
        o.setUpdatedTimestamp(DateUtil.getDate(row[26]));// 26-updated_at
       return o;
    }
}


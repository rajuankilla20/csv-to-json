package util;

import com.opencsv.CSVReader;
import model.gpod.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FinalOrdersUtil {


    // percentage , none , custom, fixed, 5,7,10,12,15

    public static void buildUserOrders(/*Map<Integer,Set<PosOrdersGpod>> posOrdersGpodMap,*/
                                       List<FinalUserOrders> finalUserOrdersList,
                                       Map<Integer,OrderStatusGpod> orderStatusGpodMap,
                                       Map<Integer, Set<OrderStatusChangeGpod>> orderStatusChangeGpodMap,
                                       Map<Integer,OrdersGpod> ordersGpodMap,
                                       Map<Integer,Set<OrderItemsGpod>> orderItemsGpodMap,
                                       Map<Integer, ProductGpod> productMap,
                                       Map<Integer,UserGpod> userGpodMap) {
        /*
         Step.0 - iterate ordersGpodMap and make which is having the complete user orders
                 1. userOrders<uid, Set<Orders>
         Step.1. iterate orderStatusChangeGpodMap and get the latest order status by sorting to descending order and pick the last
         Step.2. get Order by ordersGpodMap.get(orderId)
         Step.3. get order items by orderItemsGpodMap.get(orderId)
         Step.4 Convert orderStatusChange set to list and sort orderStatusChange list for audit to order object
                4.1. UserOrders.setxxx(orders.getxxx)
         Step.5. build Order
                1. Items.setXXX(order_items.getxxx)
                2. add items to Order
         Step.6. Set FinalUser by id
         Step.7. add FinalUser to List
         */

        //Step.0
        Map<Integer,Set<OrdersGpod>> userOrdersMap = new HashMap<>();

        ordersGpodMap.forEach( (orderId,order) ->{
                // NOTE order.getId() is userId
                if(userOrdersMap.containsKey(order.getId())){
                    Set<OrdersGpod> orders = userOrdersMap.get(order.getId());
                    orders.add(order);
                    userOrdersMap.put(order.getId(),orders);
                }else{
                    Set<OrdersGpod> orders = new HashSet<>();
                    orders.add(order);
                    userOrdersMap.put(order.getId(),orders);
                }


        });

        userOrdersMap.forEach((userId, userOrdersSet) ->{
            FinalUserOrders finalUserOrders = new FinalUserOrders();

            userOrdersSet.forEach(userOrder -> {
                int orderId = userOrder.getoId();

                Set<OrderStatusChangeGpod> statusChangeGpodSet = orderStatusChangeGpodMap.get(userOrder.getoId());

                List<OrderStatusChange> orderStatusChangeHistory= new ArrayList<>();

                // Step.1 sorting descending order to get the latest status at 0. position
                statusChangeGpodSet.forEach(orderStatusChangeGpod -> {

                    OrderStatusChange orderStatusChange = new OrderStatusChange();
                    orderStatusChange.setOsId(orderStatusChangeGpod.getOsId());
                    // getting order status name from map
                    orderStatusChange.setOrderStatus(orderStatusGpodMap.get(orderStatusChangeGpod.getOsId()).getName());
                    orderStatusChange.setChangesBy(orderStatusChangeGpod.getChangesBy());
                    orderStatusChange.setChangesById(orderStatusChangeGpod.getChangesById());
                    orderStatusChange.setCreatedTimestamp(orderStatusChangeGpod.getCreatedTimestamp());
                    orderStatusChange.setUpdatedTimestamp(orderStatusChangeGpod.getUpdatedTimestamp());
                    orderStatusChangeHistory.add(orderStatusChange);
                });

                Collections.sort(orderStatusChangeHistory, (status1, status2) -> status2.getOsId() - status1.getOsId());

                // Step.2
               // OrdersGpod  ordersGpod = ordersGpodMap.get(orderId);

                // Step.3
                Set<OrderItemsGpod> orderItemsGpodsSet = orderItemsGpodMap.get(orderId);

                // Step.4.1 build  Order and set
                UserOrders userOrders = prepareUserOrder(userGpodMap.get(userId).getEmail(),userOrder,orderStatusChangeHistory.get(0).getOrderStatus(), orderItemsGpodsSet.size());

                Map<Integer, OrderItemsGpod> productOrderItemMap = new HashMap<>();

                orderItemsGpodMap.forEach((id,orderItemsGpods) -> {
                    orderItemsGpods.forEach(oi -> {
                        productOrderItemMap.put(oi.getProductId(),oi);
                    });

                });

                // Step.5. build Order
                List<Items> items = prepareItems(orderItemsGpodsSet,productMap,productOrderItemMap);
                userOrders.getItems().addAll(items);
                userOrders.getOrderStatusChange().addAll(orderStatusChangeHistory);

                finalUserOrders.getUserOrders().add(userOrders);
                // ordersGpod.getId() is userId
//                UserGpod userGpod = userGpodMap.get(userId);


            }); // end of each user orders

            finalUserOrders.setUserId(userGpodMap.get(userId).getEmail());
            finalUserOrdersList.add(finalUserOrders);
        });
    }

    private static List<Items> prepareItems(Set<OrderItemsGpod> orderItemsGpodsSet,Map<Integer, ProductGpod> productMap, Map<Integer, OrderItemsGpod> productOrderItemMap) {
        List<Items> itemsList = new ArrayList<>();

        orderItemsGpodsSet.forEach(oi -> {
            Items item = new Items();
            ProductGpod p = productMap.get(oi.getProductId());
            item.setId(oi.getProductId());
            item.setBrand(p.getBrands().get(0).getDesc());
            item.setCode(p.getCode());
            item.setDesc(p.getDesc());
            item.setImageUri(p.getImageName());
            item.setOrderItemStatus("Completed");
            item.setPrice(p.getPrice().getBasePrice());
            OrderItemsGpod x = productOrderItemMap.get(oi.getProductId());
            item.setQuantity(productOrderItemMap.get(oi.getProductId()).getQuantity());
            item.setTax(p.getTax());
            item.setType(p.getType().getDesc());
            item.setWeight(p.getWeight());
            item.setWeightType(p.getWeightType());
            itemsList.add(item);
        });

        return itemsList;
    }

    private static UserOrders prepareUserOrder(String email,OrdersGpod ordersGpod, String orderStatus, int orderItemCount) {
        UserOrders userOrders = new UserOrders();

        userOrders.setEmail(email);
        userOrders.setDeliveryTip(ordersGpod.getTipType());
        userOrders.setDeliveryTipAmount(ordersGpod.getTip());
        userOrders.setOrderNumber(ordersGpod.getoId());
        userOrders.setOrderStatus(orderStatus);
        userOrders.setOrderTimestamp(ordersGpod.getInvoiceDate());
        userOrders.setPromoCode("");
            SelectedPickupTime selectedPickupTime = new SelectedPickupTime();
            selectedPickupTime.setDayName(DateUtil.getDayName(ordersGpod.getInvoiceDate()));
            selectedPickupTime.setStartTime(ordersGpod.getPickupTime().split("-")[0]);
            selectedPickupTime.setEndTime(ordersGpod.getPickupTime().split("-")[1]);
            selectedPickupTime.setPickupLocation(ordersGpod.getPickupLocation());
        userOrders.setSelectedPickupTime(selectedPickupTime);
        userOrders.setSubTotal(ordersGpod.getFinalSubtotal());
        userOrders.setSubstituteOption(ordersGpod.getFinalSubtotal() == 1 ? true : false);
        userOrders.setTax(ordersGpod.getTax());
        userOrders.setTotal(ordersGpod.getGrandTotal());
        userOrders.setTotalItemCount(orderItemCount);
        userOrders.setCreatedTimestamp(ordersGpod.getCreatedTimestamp());
        userOrders.setUpdatedTimestamp(ordersGpod.getUpdatedTimestamp());

        return  userOrders;

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
        o.setInvoiceDate(DateUtil.getYYYMMDDDate(row[10]));  // 10-"invoice_date"
        o.setCouponId(row[11]);  // 11-"couponid"
        o.setCouponDiscount(row[12]);  // 12-"coupon_discount"
        o.setFinalSubtotal(Double.parseDouble(row[13])); // 13-"final_subtotal"
        o.setShippingChargeNet(0); // 14-"shipping_charge_net" ,ignoring to 0
        o.setTax(Double.parseDouble(row[15])); // 15-"tax"
        if("NULL".equalsIgnoreCase(row[16])){
            o.setTip(0); // 16-"tip"
        }else{
            o.setTip(Double.parseDouble(row[16])); // 16-"tip"
        }

        o.setTipType(row[17]);  // 17-"tip_type"
        o.setGrandTotal(Double.parseDouble(row[18])); // 18-"grand_total"
        o.setIp(row[19]);  // 19-"ip"
        o.setPaymentMethod(row[20]);  // 20-"payment_method"
        o.setPickupDate(DateUtil.getYYYMMDDDate(row[21]));  // 21-"pickup_date"
        o.setPickupTime(row[22]);  // 22-"pickup_time"
        o.setPickupLocation(row[23]);  // 23-"pickup_location"
        o.setSubstituteOption(Integer.parseInt(row[24]));  // 24-"substitute_option"
        o.setCreatedTimestamp(DateUtil.getDate(row[25]));// 25-created_at
        o.setUpdatedTimestamp(DateUtil.getDate(row[26]));// 26-updated_at
       return o;
    }
}


package model.gpod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserOrders {
    private String deliveryTip;
    private double deliveryTipAmount;
    private String email;
    private int orderNumber;
    private List<Items> items = new ArrayList<>();
    private String orderStatus;
    private Date orderTimestamp;
    private String promoCode;
    private SelectedPickupTime selectedPickupTime;
    private double subTotal;
    private boolean substituteOption;
    private double tax;
    private double total;
    private int totalItemCount;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    List<OrderStatusChange> orderStatusChange = new ArrayList<>();

    public UserOrders() {
    }

    public String getDeliveryTip() {
        return deliveryTip;
    }

    public void setDeliveryTip(String deliveryTip) {
        this.deliveryTip = deliveryTip;
    }

    public double getDeliveryTipAmount() {
        return deliveryTipAmount;
    }

    public void setDeliveryTipAmount(double deliveryTipAmount) {
        this.deliveryTipAmount = deliveryTipAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Date orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public SelectedPickupTime getSelectedPickupTime() {
        return selectedPickupTime;
    }

    public void setSelectedPickupTime(SelectedPickupTime selectedPickupTime) {
        this.selectedPickupTime = selectedPickupTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public boolean isSubstituteOption() {
        return substituteOption;
    }

    public void setSubstituteOption(boolean substituteOption) {
        this.substituteOption = substituteOption;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<OrderStatusChange> getOrderStatusChange() {
        return orderStatusChange;
    }

    public void setOrderStatusChange(List<OrderStatusChange> orderStatusChange) {
        this.orderStatusChange = orderStatusChange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserOrders{" +
                "deliveryTip='" + deliveryTip + '\'' +
                ", deliveryTipAmount=" + deliveryTipAmount +
                ", email='" + email + '\'' +
                ", orderNumber=" + orderNumber +
                ", items=" + items +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTimestamp=" + orderTimestamp +
                ", promoCode='" + promoCode + '\'' +
                ", selectedPickupTime=" + selectedPickupTime +
                ", subTotal=" + subTotal +
                ", substituteOption=" + substituteOption +
                ", tax=" + tax +
                ", total=" + total +
                ", totalItemCount=" + totalItemCount +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", orderStatusChange=" + orderStatusChange +
                '}';
    }
}

package model.gpod;

import java.util.Date;
import java.util.Objects;

public class OrdersGpod {
    private int oId; // 0-"oid"
    private int id; //  1-"id" (userid)
    private String invoiceNo; // 2-"invoice_no"
    private String billingFullName; // 4-"billing_full_name"
    private String paymentGatewayTransactionStatus; // 9-"payment_gateway_transaction_status"
    private Date invoiceDate; // 10-"invoice_date"
    private String couponId; //  11-"couponid"
    private String couponDiscount; //   12-"coupon_discount"
    private double finalSubtotal; //    13-"final_subtotal"
    private double shippingChargeNet; //    14-"shipping_charge_net"
    private double tax; //    15-"tax"
    private double tip; //    16-"tip"
    private String tipType; //  17-"tip_type"
    private double grandTotal; //    18-"grand_total" - Total
    private String ip; //   19-"ip"
    private String paymentMethod; //  20-"payment_method"
    private Date pickupDate; //21-"pickup_date"
    private String pickupTime; //  22-"pickup_time"
    private String pickupLocation; //  23-"pickup_location"
    private int substituteOption; //   24-"substitute_option"
    private Date createdTimestamp; // 25-"created_at"
    private Date updatedTimestamp; //26-"updated_at"


    public OrdersGpod() {
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getBillingFullName() {
        return billingFullName;
    }

    public void setBillingFullName(String billingFullName) {
        this.billingFullName = billingFullName;
    }

    public String getPaymentGatewayTransactionStatus() {
        return paymentGatewayTransactionStatus;
    }

    public void setPaymentGatewayTransactionStatus(String paymentGatewayTransactionStatus) {
        this.paymentGatewayTransactionStatus = paymentGatewayTransactionStatus;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public double getFinalSubtotal() {
        return finalSubtotal;
    }

    public void setFinalSubtotal(double finalSubtotal) {
        this.finalSubtotal = finalSubtotal;
    }

    public double getShippingChargeNet() {
        return shippingChargeNet;
    }

    public void setShippingChargeNet(double shippingChargeNet) {
        this.shippingChargeNet = shippingChargeNet;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getTipType() {
        return tipType;
    }

    public void setTipType(String tipType) {
        this.tipType = tipType;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int getSubstituteOption() {
        return substituteOption;
    }

    public void setSubstituteOption(int substituteOption) {
        this.substituteOption = substituteOption;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersGpod that = (OrdersGpod) o;
        return oId == that.oId &&
                id == that.id &&
                Double.compare(that.finalSubtotal, finalSubtotal) == 0 &&
                Double.compare(that.shippingChargeNet, shippingChargeNet) == 0 &&
                Double.compare(that.tax, tax) == 0 &&
                Double.compare(that.tip, tip) == 0 &&
                Double.compare(that.grandTotal, grandTotal) == 0 &&
                substituteOption == that.substituteOption &&
                Objects.equals(invoiceNo, that.invoiceNo) &&
                Objects.equals(billingFullName, that.billingFullName) &&
                Objects.equals(paymentGatewayTransactionStatus, that.paymentGatewayTransactionStatus) &&
                Objects.equals(invoiceDate, that.invoiceDate) &&
                Objects.equals(couponId, that.couponId) &&
                Objects.equals(couponDiscount, that.couponDiscount) &&
                Objects.equals(tipType, that.tipType) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(pickupTime, that.pickupTime) &&
                Objects.equals(pickupLocation, that.pickupLocation) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, id, invoiceNo, billingFullName, paymentGatewayTransactionStatus, invoiceDate, couponId, couponDiscount, finalSubtotal, shippingChargeNet, tax, tip, tipType, grandTotal, ip, paymentMethod, pickupDate, pickupTime, pickupLocation, substituteOption, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "OrdersGpod{" +
                "oId=" + oId +
                ", id=" + id +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", billingFullName='" + billingFullName + '\'' +
                ", paymentGatewayTransactionStatus='" + paymentGatewayTransactionStatus + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", couponId='" + couponId + '\'' +
                ", couponDiscount='" + couponDiscount + '\'' +
                ", finalSubtotal=" + finalSubtotal +
                ", shippingChargeNet=" + shippingChargeNet +
                ", tax=" + tax +
                ", tip=" + tip +
                ", tipType='" + tipType + '\'' +
                ", grandTotal=" + grandTotal +
                ", ip='" + ip + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", pickupDate=" + pickupDate +
                ", pickupTime='" + pickupTime + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", substituteOption=" + substituteOption +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

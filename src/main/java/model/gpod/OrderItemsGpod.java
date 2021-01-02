package model.gpod;

import java.util.Date;
import java.util.Objects;

public class OrderItemsGpod {

// Items
//    id: string;
//    code: string;
//    desc: string;
//    price: number;
//    brand: string;
//    weight: string;
//    weightType: string;
//    imageUri: string;
//    quantity: number;
//    type: string;
//    tax: number;

    private int oiId;
    private int oId;
    private int productId;
    private String title;
    private String productType;
    private int quantity;
    private double cost;
    private double subTotal;
    private String substituteProduct;
    private int substituteQuantity;
    private String substitute;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public OrderItemsGpod() {
    }

    public int getOiId() {
        return oiId;
    }

    public void setOiId(int oiId) {
        this.oiId = oiId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getSubstituteProduct() {
        return substituteProduct;
    }

    public void setSubstituteProduct(String substituteProduct) {
        this.substituteProduct = substituteProduct;
    }

    public int getSubstituteQuantity() {
        return substituteQuantity;
    }

    public void setSubstituteQuantity(int substituteQuantity) {
        this.substituteQuantity = substituteQuantity;
    }

    public String getSubstitute() {
        return substitute;
    }

    public void setSubstitute(String substitute) {
        this.substitute = substitute;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "OrderItemsGpod{" +
                "oiId=" + oiId +
                ", oId=" + oId +
                ", productId=" + productId +
                ", title='" + title + '\'' +
                ", productType='" + productType + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", subTotal=" + subTotal +
                ", substituteProduct='" + substituteProduct + '\'' +
                ", substituteQuantity=" + substituteQuantity +
                ", substitute='" + substitute + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsGpod that = (OrderItemsGpod) o;
        return oiId == that.oiId &&
                oId == that.oId &&
                productId == that.productId &&
                quantity == that.quantity &&
                Double.compare(that.cost, cost) == 0 &&
                Double.compare(that.subTotal, subTotal) == 0 &&
                Double.compare(that.substituteQuantity, substituteQuantity) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(substituteProduct, that.substituteProduct) &&
                Objects.equals(substitute, that.substitute) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oiId, oId, productId, title, productType, quantity, cost, subTotal, substituteProduct, substituteQuantity, substitute, createdTimestamp, updatedTimestamp);
    }

}

package model.gpod;

import java.util.Date;
import java.util.Objects;

public class Items {

    private int id;
    private String brand;
    private String code;
    private String desc;
    private String imageUri; // image name
    private boolean isActive;
    private String orderItemStatus;
    private double price;
    private int quantity;
    private double tax;
    private String type;
    private String weight;
    private String weightType;

    public Items() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", imageUri='" + imageUri + '\'' +
                ", isActive=" + isActive +
                ", orderItemStatus='" + orderItemStatus + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", tax=" + tax +
                ", type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                ", weightType='" + weightType + '\'' +
                '}';
    }
}

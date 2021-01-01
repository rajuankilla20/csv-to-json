package model.gpod;

import model.Price;

import java.util.Date;
import java.util.Objects;

public class FavouritesGpod {
    private int id;
    private String code;
    private String image;
    private boolean isActive;
    private Price price;
    private String weight;
    private String weightType;

    public FavouritesGpod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavouritesGpod that = (FavouritesGpod) o;
        return id == that.id &&
                isActive == that.isActive &&
                Objects.equals(code, that.code) &&
                Objects.equals(image, that.image) &&
                Objects.equals(price, that.price) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(weightType, that.weightType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, image, isActive, price, weight, weightType);
    }

    @Override
    public String toString() {
        return "FavouritesGpod{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                ", isActive=" + isActive +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", weightType='" + weightType + '\'' +
                '}';
    }
}

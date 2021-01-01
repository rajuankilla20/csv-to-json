package model;

import java.util.Objects;

public class Price {
    private double basePrice=0.0;
    private double discountPrice=0.0;

    public Price(double basePrice, double discountPrice) {
        this.basePrice = basePrice;
        this.discountPrice = discountPrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.basePrice, basePrice) == 0 &&
                Double.compare(price.discountPrice, discountPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discountPrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "basePrice=" + basePrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}

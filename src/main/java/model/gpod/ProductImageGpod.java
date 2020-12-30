package model.gpod;

import java.util.Objects;

public class ProductImageGpod {
    private int productId;
    private String imageName;

    public ProductImageGpod() {
    }

    public ProductImageGpod(int productId, String imageName) {
        this.productId = productId;
        this.imageName = imageName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImageGpod that = (ProductImageGpod) o;
        return productId == that.productId &&
                imageName == that.imageName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, imageName);
    }

    @Override
    public String toString() {
        return "ProductImageGpod{" +
                "productId=" + productId +
                ", imageName=" + imageName +
                '}';
    }
}

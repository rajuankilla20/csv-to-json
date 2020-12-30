package model.gpod;

import java.util.Objects;

public class ProductCategoryGpod {
    private int productId;
    private int categoryId;

    public ProductCategoryGpod() {
    }

    public ProductCategoryGpod(int productId, int categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryGpod that = (ProductCategoryGpod) o;
        return productId == that.productId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId);
    }

    @Override
    public String toString() {
        return "ProductCategoryGpod{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                '}';
    }
}

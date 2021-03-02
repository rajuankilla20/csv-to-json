package model.json;

import java.util.Date;
import java.util.Objects;

public class CategoryJson {
    private int id;
    private String desc;
    private String code;
    private String imageName;
    private int productCateogryId;
    private String createdTimestamp;
    private String updatedTimestamp;
    private boolean isActive;

    public CategoryJson() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getProductCateogryId() {
        return productCateogryId;
    }

    public void setProductCateogryId(int productCateogryId) {
        this.productCateogryId = productCateogryId;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJson that = (CategoryJson) o;
        return id == that.id &&
                productCateogryId == that.productCateogryId &&
                isActive == that.isActive &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(code, that.code) &&
                Objects.equals(imageName, that.imageName) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, code, imageName, productCateogryId, createdTimestamp, updatedTimestamp, isActive);
    }

    @Override
    public String toString() {
        return "CategoryGpod{" +
                "cid=" + id +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", imageName='" + imageName + '\'' +
                ", productCateogryId=" + productCateogryId +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", isActive=" + isActive +
                '}';
    }
}

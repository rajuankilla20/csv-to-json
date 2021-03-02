package model.json;

import model.Category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SubCategoryJson {

    private int id;
    private String code;
    private String desc;
    private String imageName;
    private List<Category>  categories = new ArrayList<>();
    private boolean isActive;
    private String createdTimestamp;
    private String updatedTimestamp;

    public SubCategoryJson(){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
        SubCategoryJson that = (SubCategoryJson) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, desc);
    }

    @Override
    public String toString() {
        return "SubCategoryGpod{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", imageName='" + imageName + '\'' +
                ", categories=" + categories +
                ", isActive=" + isActive +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

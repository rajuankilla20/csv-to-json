package model.json;

import java.util.Objects;

public class BrandsJson {
    private int id;
    private String desc;
    private String code;
    private String imageName;
    private String createdTimestamp;
    private String updatedTimestamp;
    private boolean isActive;

    public BrandsJson() {
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandsJson that = (BrandsJson) o;
        return id == that.id &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(code, that.code) &&
                Objects.equals(imageName, that.imageName) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, code, imageName, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "CategoryGpod{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", imageName='" + imageName + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", isActive=" + isActive +
                '}';
    }
}

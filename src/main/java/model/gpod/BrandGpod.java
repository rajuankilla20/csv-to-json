package model.gpod;

import java.util.Date;
import java.util.Objects;

public class BrandGpod {
    private int id;
    private String desc;
    private String code;
    private String imageName;
    private Date createdTimestamp;
    private Date updatedTimestamp;
    private boolean isActive;

    public BrandGpod() {
    }

    public BrandGpod(int id, String desc, String code, String imageName, boolean isActive, Date createdTimestamp, Date updatedTimestamp) {
        this.id = id;
        this.desc = desc;
        this.code = code;
        this.imageName = imageName;
        this.isActive=isActive;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandGpod that = (BrandGpod) o;
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

package model.gpod;

import java.util.Date;
import java.util.Objects;

public class AttributeGpod {
    private int id;
    private String desc;
    private String type;
    private boolean isActive;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public AttributeGpod() {
    }

    public AttributeGpod(int id, String desc, String type, boolean isActive, Date createdTimestamp, Date updatedTimestamp) {
        this.id = id;
        this.desc = desc;
        this.type = type;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
        this.isActive = isActive;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        AttributeGpod that = (AttributeGpod) o;
        return id == that.id &&
                isActive == that.isActive &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, type, createdTimestamp, updatedTimestamp, isActive);
    }

    @Override
    public String toString() {
        return "AttributeGpod{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", isActive=" + isActive +
                '}';
    }
}

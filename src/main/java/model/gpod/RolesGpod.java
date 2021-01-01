package model.gpod;

import java.util.Date;
import java.util.Objects;

public class RolesGpod {
    private int id;
    private String name;
    private Date createdTimestamp;
    private Date updatedTimestamp;
    private boolean isActive;


    public RolesGpod() {
    }

    public RolesGpod(int id, String name, Date createdTimestamp, Date updatedTimestamp, boolean isActive) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        RolesGpod rolesGpod = (RolesGpod) o;
        return id == rolesGpod.id &&
                isActive == rolesGpod.isActive &&
                Objects.equals(name, rolesGpod.name) &&
                Objects.equals(createdTimestamp, rolesGpod.createdTimestamp) &&
                Objects.equals(updatedTimestamp, rolesGpod.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdTimestamp, updatedTimestamp, isActive);
    }

    @Override
    public String toString() {
        return "RolesGpod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", isActive=" + isActive +
                '}';
    }
}

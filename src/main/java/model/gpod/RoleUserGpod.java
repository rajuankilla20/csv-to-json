package model.gpod;

import java.util.Date;
import java.util.Objects;

public class RoleUserGpod {
    private int id;
    private int roleId;
    private int userId;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public RoleUserGpod() {
    }

    public RoleUserGpod(int id, int roleId, int userId, Date createdTimestamp, Date updatedTimestamp) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUserGpod that = (RoleUserGpod) o;
        return id == that.id &&
                roleId == that.roleId &&
                userId == that.userId &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, userId, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "RolesUserGpod{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

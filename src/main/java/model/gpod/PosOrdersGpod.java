package model.gpod;

import java.util.Date;
import java.util.Objects;

public class PosOrdersGpod {
    private int id;
    private int oId;
    private int uid;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public PosOrdersGpod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
        PosOrdersGpod that = (PosOrdersGpod) o;
        return id == that.id &&
                oId == that.oId &&
                uid == that.uid &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oId, uid, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "PosOrdersGpod{" +
                "id=" + id +
                ", oId=" + oId +
                ", uid=" + uid +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

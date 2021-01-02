package model.gpod;

import java.util.Date;
import java.util.Objects;

public class OrderStatusChangeGpod {
    private int oscId;
    private int oId;
    private int osId;
    private String changesBy;
    private String changesById;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public OrderStatusChangeGpod() {
    }

    public int getOscId() {
        return oscId;
    }

    public void setOscId(int oscId) {
        this.oscId = oscId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public String getChangesBy() {
        return changesBy;
    }

    public void setChangesBy(String changesBy) {
        this.changesBy = changesBy;
    }

    public String getChangesById() {
        return changesById;
    }

    public void setChangesById(String changesById) {
        this.changesById = changesById;
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
        OrderStatusChangeGpod that = (OrderStatusChangeGpod) o;
        return oscId == that.oscId &&
                oId == that.oId &&
                osId == that.osId &&
                Objects.equals(changesBy, that.changesBy) &&
                Objects.equals(changesById, that.changesById) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oscId, oId, osId, changesBy, changesById, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "OrderStatusChangeGpod{" +
                "oscId=" + oscId +
                ", oId=" + oId +
                ", osId=" + osId +
                ", changesBy='" + changesBy + '\'' +
                ", changesById='" + changesById + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

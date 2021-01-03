package model.gpod;

import java.util.Date;
import java.util.Objects;

public class OrderStatusChange {
    private int osId;
    private String orderStatus;
    private String changesBy;
    private String changesById;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public OrderStatusChange() {
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
    public String toString() {
        return "OrderStatusChange{" +
                "osId=" + osId +
                ", orderStatus='" + orderStatus + '\'' +
                ", changesBy='" + changesBy + '\'' +
                ", changesById='" + changesById + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

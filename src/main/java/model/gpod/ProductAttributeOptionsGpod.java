package model.gpod;

import java.util.Date;
import java.util.Objects;

public class ProductAttributeOptionsGpod {
    private int pAoId;
    private int pId;
    private int aId;
    private int aoId;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public ProductAttributeOptionsGpod() {
    }

    public ProductAttributeOptionsGpod(int pAoId, int pId, int aId, int aoId, Date createdTimestamp, Date updatedTimestamp) {
        this.pAoId = pAoId;
        this.pId = pId;
        this.aId = aId;
        this.aoId = aoId;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public int getpAoId() {
        return pAoId;
    }

    public void setpAoId(int pAoId) {
        this.pAoId = pAoId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getAoId() {
        return aoId;
    }

    public void setAoId(int aoId) {
        this.aoId = aoId;
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
        ProductAttributeOptionsGpod that = (ProductAttributeOptionsGpod) o;
        return pAoId == that.pAoId &&
                pId == that.pId &&
                aId == that.aId &&
                aoId == that.aoId &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pAoId, pId, aId, aoId, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "ProductAttributeOptionsGpod{" +
                "pAoId=" + pAoId +
                ", pId=" + pId +
                ", aId=" + aId +
                ", aoId=" + aoId +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

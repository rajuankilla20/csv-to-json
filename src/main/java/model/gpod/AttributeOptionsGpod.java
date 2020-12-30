package model.gpod;

import java.util.Date;
import java.util.Objects;

public class AttributeOptionsGpod {
    private int ao_id;
    private int atid;
    private String desc;
    private  int weight;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public AttributeOptionsGpod() {
    }

    public AttributeOptionsGpod(int ao_id, int atid, String desc, int weight, Date createdTimestamp, Date updatedTimestamp) {
        this.ao_id = ao_id;
        this.atid = atid;
        this.desc = desc;
        this.weight = weight;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public int getAo_id() {
        return ao_id;
    }

    public void setAo_id(int ao_id) {
        this.ao_id = ao_id;
    }

    public int getAtid() {
        return atid;
    }

    public void setAtid(int atid) {
        this.atid = atid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
        AttributeOptionsGpod that = (AttributeOptionsGpod) o;
        return ao_id == that.ao_id &&
                atid == that.atid &&
                weight == that.weight &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ao_id, atid, desc, weight, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "AttributeOptionsGpod{" +
                "ao_id=" + ao_id +
                ", atid=" + atid +
                ", desc='" + desc + '\'' +
                ", weight=" + weight +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

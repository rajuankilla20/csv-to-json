package model;

import java.util.Objects;

public class Deal {
    private String code;
    private String desc;

    public Deal(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return Objects.equals(code, deal.code) &&
                Objects.equals(desc, deal.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, desc);
    }

    @Override
    public String toString() {
        return "Deal{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

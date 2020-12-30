package model;

import java.util.Objects;

public class Brand {
    private String code;
    private String desc;

    public Brand(String code, String desc) {
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
        Brand brands = (Brand) o;
        return Objects.equals(code, brands.code) &&
                Objects.equals(desc, brands.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, desc);
    }
}

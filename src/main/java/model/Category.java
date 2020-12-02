package model;

import java.util.Objects;

public class Category {

    private String code;
    private String desc;

    public Category(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category categories = (Category) o;
        return Objects.equals(code, categories.code) &&
                Objects.equals(desc, categories.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, desc);
    }
}

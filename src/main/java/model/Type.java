package model;

import java.util.Objects;

public class Type {
    private String code;
    private String desc;

    public Type(String code, String desc) {
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
        Type type = (Type) o;
        return Objects.equals(code, type.code) &&
                Objects.equals(desc, type.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, desc);
    }

    @Override
    public String toString() {
        return "Type{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

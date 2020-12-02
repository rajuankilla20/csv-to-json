package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categories {

    private String code;
    private String desc;
    private List<SubCategory> subCategories = new ArrayList<>();

    public Categories(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories categories = (Categories) o;
        return Objects.equals(code, categories.code) &&
                Objects.equals(desc, categories.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, desc);
    }

    @Override
    public String toString() {
        return "Categories{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}

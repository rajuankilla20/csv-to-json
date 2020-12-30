package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubCategoryModel {

    private String id;
    private String code;
    private String desc;
    private List<Category>  categories = new ArrayList<>();

    public  SubCategoryModel(){

    }
    public SubCategoryModel(String id, String code, String desc) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategoryModel that = (SubCategoryModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, desc);
    }

    @Override
    public String toString() {
        return "SubCategoryModel{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

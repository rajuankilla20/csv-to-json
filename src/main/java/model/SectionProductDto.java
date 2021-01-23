package model;

import java.util.Objects;

public class SectionProductDto {
    private String name;
    private String weight;

    public SectionProductDto() {
    }

    public SectionProductDto(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionProductDto that = (SectionProductDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "SectionProductDto{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

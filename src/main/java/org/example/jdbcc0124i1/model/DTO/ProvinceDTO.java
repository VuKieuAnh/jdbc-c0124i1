package org.example.jdbcc0124i1.model.DTO;

public class ProvinceDTO {
    private String name;
    private int number;

    public ProvinceDTO() {
    }

    public ProvinceDTO(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ProvinceDTO{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

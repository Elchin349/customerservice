package com.company.customerservice.enums;

public enum SearchParams {
    STATUS(1,"status"),
    SALARY(2,"salary"),
    FIRST_NAME(3,"firstName"),
    MARTIAL_STATUS(4,"martialStatus"),
    BIRTH_PLACE(5,"birthPlace");


    private int id;
    private String name;

    SearchParams(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

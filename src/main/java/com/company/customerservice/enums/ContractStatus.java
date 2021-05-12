package com.company.customerservice.enums;

public enum ContractStatus {

    ACTIVE(1),INACTIVE(2);

    private int id;

     ContractStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

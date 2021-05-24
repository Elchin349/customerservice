package com.company.customerservice.repository;

import lombok.Data;

@Data
public class SearchCriteria {
    private String key;
    private Object value;
    private Object value2;
    private SearchOperation operation;
    private SearchOperation subOperation;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }


    public SearchCriteria(String key, Object value, Object value2, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.value2 = value2;
        this.operation = operation;
    }

    public SearchCriteria(String key, Object value, Object value2, SearchOperation operation, SearchOperation subOperation) {
        this.key = key;
        this.value = value;
        this.value2 = value2;
        this.operation = operation;
        this.subOperation = subOperation;
    }

    public SearchCriteria(String key, Object value, SearchOperation operation, SearchOperation subOperation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
        this.subOperation = subOperation;
    }
}

package com.lambdacode.spring.boot.crud.commons.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatus {
    DONE("DONE"),
    NOT_DONE("NOT_DONE");
    private final String name;

    TaskStatus(String name) {
        this.name = name;
    }

    @JsonValue
    public String getValue() {
        return this.name;
    }

}

package com.desafio.agibank.importalotes.domain.enums;

public enum DataType {

    SALESMAN("001"),
    CLIENT("002"),
    SALES("003");

    private String id;

    DataType(String id) {
        this.id = id;
    }
}

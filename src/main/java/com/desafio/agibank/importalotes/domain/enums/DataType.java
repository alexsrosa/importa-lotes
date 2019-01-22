package com.desafio.agibank.importalotes.domain.enums;

public enum DataType {

    SALESMAN("001"),
    CLIENT("002"),
    SALES("003");

    private String id;

    DataType(String id) {
        this.id = id;
    }

    public static DataType getValue(String value) throws Exception {
        switch (value) {
            case "001":
                return SALESMAN;
            case "002":
                return CLIENT;
            case "003":
                return SALES;
            default:
                throw new Exception("Value ".concat(value).concat(" not found in DataType"));
        }
    }
}

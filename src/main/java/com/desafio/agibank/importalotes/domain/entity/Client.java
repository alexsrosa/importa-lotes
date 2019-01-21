package com.desafio.agibank.importalotes.domain.entity;

import com.desafio.agibank.importalotes.domain.enums.DataType;

public class Client {

    private DataType id;
    private String cnpj;
    private String name;
    private String businessArea;

    public DataType getId() {
        return id;
    }

    public void setId(DataType id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}

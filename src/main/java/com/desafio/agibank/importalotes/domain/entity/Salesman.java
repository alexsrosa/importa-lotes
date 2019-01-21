package com.desafio.agibank.importalotes.domain.entity;

import com.desafio.agibank.importalotes.domain.enums.DataType;

import java.math.BigDecimal;

public class Salesman {

    private DataType id;
    private String cpf;
    private String name;
    private BigDecimal salary;

    public DataType getId() {
        return id;
    }

    public void setId(DataType id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

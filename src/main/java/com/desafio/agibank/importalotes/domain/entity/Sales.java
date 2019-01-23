package com.desafio.agibank.importalotes.domain.entity;

import com.desafio.agibank.importalotes.domain.enums.DataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Sales {

    private DataType id;
    private String saleId;
    private List<Item> items;
    private String SalesmanName;
    private double totalSale;

    public Sales() {
        items = new ArrayList<>();
    }

    public DataType getId() {
        return id;
    }

    public void setId(DataType id) {
        this.id = id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addNewItem(Item item) {
        if (Objects.isNull(items)) {
            items = new ArrayList<>();
        }

        items.add(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSalesmanName() {
        return SalesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        SalesmanName = salesmanName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
}

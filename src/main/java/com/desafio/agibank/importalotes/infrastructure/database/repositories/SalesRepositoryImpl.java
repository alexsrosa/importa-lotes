package com.desafio.agibank.importalotes.infrastructure.database.repositories;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.domain.repository.SalesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class SalesRepositoryImpl extends SalesRepository {

    private static List<Sales> salesList = new ArrayList<>();

    @Override
    public void clear() {
        salesList = new ArrayList<>();
    }

    @Override
    public void create(Sales entity) {
        salesList.add(entity);
    }

    @Override
    public List<Sales> findAll() {
        return salesList;
    }

    public String getSaleIdMoreExpensive() {
        Sales sales = salesList.stream()
                .max(Comparator.comparing(Sales::getTotalSale))
                .orElseThrow(NoSuchElementException::new);
        return sales.getSaleId();
    }

    public String getWorstSeller() {
        Sales sales = salesList.stream()
                .min(Comparator.comparing(Sales::getTotalSale))
                .orElseThrow(NoSuchElementException::new);
        return sales.getSalesmanName();
    }
}

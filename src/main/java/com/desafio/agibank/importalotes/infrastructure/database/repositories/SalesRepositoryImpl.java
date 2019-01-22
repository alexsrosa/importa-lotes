package com.desafio.agibank.importalotes.infrastructure.database.repositories;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.domain.repository.SalesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}

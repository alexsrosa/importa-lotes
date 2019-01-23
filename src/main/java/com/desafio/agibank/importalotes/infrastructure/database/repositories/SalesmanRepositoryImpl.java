package com.desafio.agibank.importalotes.infrastructure.database.repositories;

import com.desafio.agibank.importalotes.domain.entity.Salesman;
import com.desafio.agibank.importalotes.domain.repository.SalesmanRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalesmanRepositoryImpl extends SalesmanRepository {

    private static List<Salesman> salesmenList = new ArrayList<>();

    @Override
    public void clear() {
        salesmenList = new ArrayList<>();
    }

    @Override
    public void create(Salesman entity) {
        salesmenList.add(entity);
    }

    @Override
    public List<Salesman> findAll() {
        return salesmenList;
    }

    public Integer getTotalSalesman() {
        return salesmenList.size();
    }
}

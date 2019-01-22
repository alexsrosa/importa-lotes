package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.SalesRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepositoryImpl salesRepository;

    public SalesService(SalesRepositoryImpl salesRepository) {
        this.salesRepository = salesRepository;
    }

    public void clear() {
        salesRepository.clear();
    }

    public void create(Sales sales) {
        salesRepository.create(sales);
    }

    public List<Sales> findAll() {
        return salesRepository.findAll();
    }
}

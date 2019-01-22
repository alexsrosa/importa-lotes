package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Salesman;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.SalesmanRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {

    private final SalesmanRepositoryImpl salesmanRepository;

    public SalesmanService(SalesmanRepositoryImpl salesmanRepository) {
        this.salesmanRepository = salesmanRepository;
    }

    public void clear() {
        salesmanRepository.clear();
    }

    public void create(Salesman salesman) {
        salesmanRepository.create(salesman);
    }

    public List<Salesman> findAll() {
        return salesmanRepository.findAll();
    }
}

package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Salesman;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.SalesmanRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço do objeto {@link Salesman}.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:22:06
 */
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

    public Integer getTotalSalesman() {
        return salesmanRepository.getTotalSalesman();
    }
}

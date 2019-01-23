package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.SalesRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço do objeto {@link Sales}.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:22:06
 */
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

    public String getSaleIdMoreExpensive() {
        return salesRepository.getSaleIdMoreExpensive();
    }

    public String getWorstSeller() {
        return salesRepository.getWorstSeller();
    }
}

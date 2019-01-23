package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.ClientRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço do objeto {@link Client}.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:22:06
 */
@Service
public class ClientService {

    private final ClientRepositoryImpl clientRepository;

    public ClientService(ClientRepositoryImpl clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void clear() {
        clientRepository.clear();
    }

    public void create(Client client) {
        clientRepository.create(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Integer getTotalCustomers() {
        return clientRepository.getTotalCustomers();
    }
}

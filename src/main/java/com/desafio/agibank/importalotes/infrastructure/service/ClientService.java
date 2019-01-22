package com.desafio.agibank.importalotes.infrastructure.service;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.infrastructure.database.repositories.ClientRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

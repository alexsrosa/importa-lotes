package com.desafio.agibank.importalotes.infrastructure.database.repositories;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.domain.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryImpl extends ClientRepository {

    private static List<Client> clientList = new ArrayList<>();

    @Override
    public void clear() {
        clientList = new ArrayList<>();
    }

    @Override
    public void create(Client client) {
        clientList.add(client);
    }

    @Override
    public List<Client> findAll() {
        return clientList;
    }

    public Integer getTotalCustomers() {
        return clientList.size();
    }
}

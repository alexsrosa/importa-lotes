package com.desafio.agibank.importalotes.infrastructure.builder;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import org.springframework.stereotype.Component;

@Component
public class ClientBuilder extends Builder<Client> {

    @Override
    public Client convert(String[] values) throws Exception {

        Client client = new Client();
        client.setId(getDataType(values[0], DataType.CLIENT));
        client.setCnpj(values[1]);
        client.setName(values[2]);
        client.setBusinessArea(values[3]);

        return client;
    }
}

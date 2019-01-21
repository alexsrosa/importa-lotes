package com.desafio.agibank.importalotes.domain;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test
    public void createNewClientTest() {

        Client client = new Client();
        client.setId(DataType.CLIENT);
        client.setCnpj("2345675434544345");
        client.setName("Jose da Silva");
        client.setBusinessArea("Rural");

        Assert.assertTrue(Boolean.TRUE);
    }
}

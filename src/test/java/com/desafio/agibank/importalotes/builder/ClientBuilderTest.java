package com.desafio.agibank.importalotes.builder;

import com.desafio.agibank.importalotes.domain.entity.Client;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.infrastructure.builder.ClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientBuilderTest {

    @Autowired
    private ClientBuilder clientBuilder;

    @Test
    public void builderNewClientFromValues() throws Exception {
        Client client = clientBuilder.builder("002ç2345675434544345çJose da SilvaçRural");

        assertTrue(DataType.CLIENT.equals(client.getId()));
        assertTrue(client.getCnpj().equals("2345675434544345"));
        assertTrue(client.getName().equals("Jose da Silva"));
        assertTrue(client.getBusinessArea().equals("Rural"));
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataType() throws Exception {
        clientBuilder.builder("003ç2345675434544345çJose da SilvaçRural");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataTypeNotFound() throws Exception {
        clientBuilder.builder("005ç2345675434544345çJose da SilvaçRural");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesIsNull() throws Exception {
        clientBuilder.builder(null);
    }
}

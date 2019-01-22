package com.desafio.agibank.importalotes.builder;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.infrastructure.builder.ItemBuilder;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesBuilderTest {

    @Autowired
    private SalesBuilder salesBuilder;

    @Mock
    private ItemBuilder itemBuilder;

    @Test
    public void builderNewSalesFromValues() throws Exception {
        Sales sales = salesBuilder.builder("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");

        assertTrue(DataType.SALES.equals(sales.getId()));
        assertTrue(sales.getSaleId().equals("10"));
        assertEquals(3, sales.getItems().size());
        assertTrue(sales.getSalesmanName().equals("Pedro"));
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataType() throws Exception {
        salesBuilder.builder("002ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataTypeNotFound() throws Exception {
        salesBuilder.builder("005ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesIsNull() throws Exception {
        salesBuilder.builder(null);
    }
}

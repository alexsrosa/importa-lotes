package com.desafio.agibank.importalotes.builder;

import com.desafio.agibank.importalotes.domain.entity.Salesman;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesmanBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesmanBuilderTest {

    @Autowired
    private SalesmanBuilder salesmanBuilder;

    @Test
    public void builderNewSalesFromValues() throws Exception {
        Salesman salesman = salesmanBuilder.builder("001ç1234567891234çPedroç50000");

        assertTrue(DataType.SALESMAN.equals(salesman.getId()));
        assertTrue(salesman.getCpf().equals("1234567891234"));
        assertTrue(salesman.getName().equals("Pedro"));
        assertTrue(salesman.getSalary().equals(new BigDecimal(50000)));
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataType() throws Exception {
        salesmanBuilder.builder("002ç1234567891234çPedroç50000");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesWithErrorDataTypeNotFound() throws Exception {
        salesmanBuilder.builder("005ç1234567891234çPedroç50000");
    }

    @Test(expected = Exception.class)
    public void builderNewClientFromValuesIsNull() throws Exception {
        salesmanBuilder.builder(null);
    }
}

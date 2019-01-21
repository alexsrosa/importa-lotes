package com.desafio.agibank.importalotes.domain;

import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.domain.entity.Salesman;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SalesmanTest {

    @Test
    public void createNewSalesmanTest() {

        Salesman salesman = new Salesman();
        salesman.setId(DataType.SALESMAN);
        salesman.setCpf("1234567891234");
        salesman.setName("Pedro");
        salesman.setSalary(BigDecimal.valueOf(50000L));

        Assert.assertTrue(Boolean.TRUE);
    }
}

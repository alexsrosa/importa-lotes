package com.desafio.agibank.importalotes.domain;

import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.domain.entity.Item;
import com.desafio.agibank.importalotes.domain.entity.Sales;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SalesTest {

    private Sales sales;

    @Before
    public void init() {
        sales = new Sales();
        sales.setId(DataType.SALES);
        sales.setSaleId("10");
        sales.setSalesmanName("Pedro");
    }

    @Test
    public void createNewSalesTest() {

        sales.addNewItem(
                new Item.Builder()
                        .itemId(1)
                        .itemQuantity(10)
                        .itemPrice(BigDecimal.valueOf(100L))
                        .build());

        sales.addNewItem(
                new Item.Builder()
                        .itemId(2)
                        .itemQuantity(30)
                        .itemPrice(BigDecimal.valueOf(2.50))
                        .build());

        sales.addNewItem(
                new Item.Builder()
                        .itemId(3)
                        .itemQuantity(40)
                        .itemPrice(BigDecimal.valueOf(3.10))
                        .build());


        assertEquals(3, sales.getItems().size());
        assertTrue(Boolean.TRUE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void errorInCreateSalesdirectly() {

        sales.getItems().add(new Item.Builder()
                .itemId(1)
                .itemQuantity(10)
                .itemPrice(BigDecimal.valueOf(100L))
                .build());

    }
}

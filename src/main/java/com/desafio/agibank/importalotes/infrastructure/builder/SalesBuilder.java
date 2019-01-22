package com.desafio.agibank.importalotes.infrastructure.builder;

import com.desafio.agibank.importalotes.domain.entity.Sales;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import org.springframework.stereotype.Component;

@Component
public class SalesBuilder extends Builder<Sales> {

    private final ItemBuilder itemBuilder;

    public SalesBuilder(ItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    @Override
    public Sales convert(String[] values) throws Exception {

        Sales sales = new Sales();
        sales.setId(getDataType(values[0], DataType.SALES));
        sales.setSaleId(values[1]);
        sales.setItems(itemBuilder.builder(values[2]));
        sales.setSalesmanName(values[3]);

        return sales;
    }
}

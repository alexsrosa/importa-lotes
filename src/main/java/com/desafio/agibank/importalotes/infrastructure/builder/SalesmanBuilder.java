package com.desafio.agibank.importalotes.infrastructure.builder;

import com.desafio.agibank.importalotes.domain.entity.Salesman;
import com.desafio.agibank.importalotes.domain.enums.DataType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SalesmanBuilder extends Builder<Salesman> {

    @Override
    public Salesman convert(String[] split) throws Exception {

        Salesman salesman = new Salesman();
        salesman.setId(getDataType(split[0], DataType.SALESMAN));
        salesman.setCpf(split[1]);
        salesman.setName(split[2]);
        salesman.setSalary(new BigDecimal(split[3]));

        return salesman;
    }
}

package com.desafio.agibank.importalotes.infrastructure.builder;

import com.desafio.agibank.importalotes.domain.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ItemBuilder {

    @Value("${appconfig.file.delimiter.items}")
    private String delimiter;

    @Value("${appconfig.file.delimiter.item}")
    private String delimiterItem;

    public List<Item> builder(String values) throws Exception {

        if (Objects.isNull(values)) {
            throw new Exception("Values is null!");
        }

        StringBuilder builder = new StringBuilder(values);
        builder.deleteCharAt(0);
        builder.deleteCharAt(values.length() - 2);

        return convert(builder.toString().split(delimiter));
    }

    public List<Item> convert(String[] values) {

        List<Item> items = new ArrayList<>();

        for (String value : values) {

            String[] item = value.split(delimiterItem);

            items.add(new Item.Builder()
                    .itemId(Integer.valueOf(item[0]))
                    .itemQuantity(Integer.valueOf(item[1]))
                    .itemPrice(new BigDecimal(item[2]))
                    .build());
        }

        return items;
    }
}

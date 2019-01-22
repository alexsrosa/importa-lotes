package com.desafio.agibank.importalotes.infrastructure.builder;

import com.desafio.agibank.importalotes.domain.enums.DataType;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

public abstract class Builder<c> {

    @Value("${appconfig.file.delimiter.register}")
    private String delimiter;

    public c builder(String values) throws Exception {

        if (Objects.isNull(values)) {
            throw new Exception("Values is null!");
        }

        return convert(values.split(delimiter));
    }

    public DataType getDataType(String value, DataType dataTypeObject) throws Exception {

        DataType dataType = DataType.getValue(value);

        if (!dataTypeObject.equals(dataType)) {
            throw new Exception("Datatype error!");
        }

        return dataType;
    }

    public abstract c convert(String[] split) throws Exception;
}

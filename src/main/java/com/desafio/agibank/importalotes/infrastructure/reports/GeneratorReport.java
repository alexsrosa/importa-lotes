package com.desafio.agibank.importalotes.infrastructure.reports;

import com.desafio.agibank.importalotes.infrastructure.dto.ReportDto;
import com.desafio.agibank.importalotes.infrastructure.helpers.FileWriterHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeneratorReport {

    private final FileWriterHelper fileWriter;

    public GeneratorReport(FileWriterHelper fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void generate(ReportDto dto, String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Quantidade de clientes no arquivo de entrada ").append(dto.getClientsAmount()).append("\n")
                .append("Quantidade de vendedor no arquivo de entrada ").append(dto.getSalesmanAmount()).append("\n")
                .append("ID da venda mais cara ").append(dto.getSaleIdMoreExpensive()).append("\n")
                .append("O pior vendedor ").append(dto.getWorstSeller());

        fileWriter.write(stringBuilder.toString(), fileName);
    }
}

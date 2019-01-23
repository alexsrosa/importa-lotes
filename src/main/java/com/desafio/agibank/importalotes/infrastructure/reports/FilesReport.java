package com.desafio.agibank.importalotes.infrastructure.reports;

import com.desafio.agibank.importalotes.infrastructure.dto.ReportDto;
import com.desafio.agibank.importalotes.infrastructure.helpers.FileWriterHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe responsável pela geração do relatório do processamento dos arquivos.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:20:51
 */
@Component
public class FilesReport {

    @Value("${appconfig.file.out}")
    private String locationOut;

    @Value("${appconfig.file.includenamedone}")
    private String nameDone;

    private final FileWriterHelper fileWriter;

    public FilesReport(FileWriterHelper fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void generate(ReportDto dto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Quantidade de clientes no arquivo de entrada ").append(dto.getClientsAmount()).append("\n")
                .append("Quantidade de vendedor no arquivo de entrada ").append(dto.getSalesmanAmount()).append("\n")
                .append("ID da venda mais cara ").append(dto.getSaleIdMoreExpensive()).append("\n")
                .append("O pior vendedor ").append(dto.getWorstSeller());

        fileWriter.write(locationOut, nameDone, stringBuilder.toString(), dto.getFileName());
    }
}

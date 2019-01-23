package com.desafio.agibank.importalotes.infrastructure.processor;

import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.infrastructure.builder.ClientBuilder;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesBuilder;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesmanBuilder;
import com.desafio.agibank.importalotes.infrastructure.dto.ReportDto;
import com.desafio.agibank.importalotes.infrastructure.helpers.FileReaderHelper;
import com.desafio.agibank.importalotes.infrastructure.reports.FilesReport;
import com.desafio.agibank.importalotes.infrastructure.service.ClientService;
import com.desafio.agibank.importalotes.infrastructure.service.SalesService;
import com.desafio.agibank.importalotes.infrastructure.service.SalesmanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Classe de processamento da importação dos arquivos.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:20:04
 */
@Component
public class ProcessImportFiles {

    private final FileReaderHelper fileReader;
    private final ClientBuilder clientBuilder;
    private final SalesmanBuilder salesmanBuilder;
    private final SalesBuilder salesBuilder;
    private final SalesService salesService;
    private final SalesmanService salesmanService;
    private final ClientService clientService;
    private final FilesReport generatorReport;

    @Value("${appconfig.file.in}")
    private String locationIn;

    @Value("${appconfig.file.extensionpattern}")
    private String extensionPattern;

    public ProcessImportFiles(FileReaderHelper fileReader,
            ClientBuilder clientBuilder,
            SalesmanBuilder salesmanBuilder,
            SalesBuilder salesBuilder,
            SalesService salesService,
            SalesmanService salesmanService,
            ClientService clientService,
            FilesReport generatorReport) {
        this.fileReader = fileReader;
        this.clientBuilder = clientBuilder;
        this.salesmanBuilder = salesmanBuilder;
        this.salesBuilder = salesBuilder;
        this.salesService = salesService;
        this.salesmanService = salesmanService;
        this.clientService = clientService;
        this.generatorReport = generatorReport;
    }

    public void run() throws Exception {
        for (Map.Entry<String, List<String>> filesMap : fileReader.readFiles(locationIn, extensionPattern).entrySet()) {
            clearObjects();
            parseValuesToObjects(filesMap);
            generateReport(filesMap.getKey());
        }
    }

    private void parseValuesToObjects(Map.Entry<String, List<String>> entry) throws Exception {
        for (String line : entry.getValue()) {
            switch (getDataType(line)) {
                case CLIENT:
                    clientService.create(clientBuilder.builder(line));
                    break;
                case SALES:
                    salesService.create(salesBuilder.builder(line));
                    break;
                case SALESMAN:
                    salesmanService.create(salesmanBuilder.builder(line));
                    break;
            }
        }
    }

    private DataType getDataType(String line) throws Exception {
        return DataType.getValue(line.substring(0, 3));
    }

    private void clearObjects() {
        clientService.clear();
        salesService.clear();
        salesmanService.clear();
    }

    private void generateReport(String fileName) {
        generatorReport.generate(
                new ReportDto.Builder()
                        .totalCustomers(clientService.getTotalCustomers())
                        .totalSalesman(salesmanService.getTotalSalesman())
                        .saleIdMoreExpensive(salesService.getSaleIdMoreExpensive())
                        .worstSeller(salesService.getWorstSeller())
                        .fileName(fileName)
                        .build());
    }
}

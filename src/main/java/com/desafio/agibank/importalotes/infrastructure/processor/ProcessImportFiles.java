package com.desafio.agibank.importalotes.infrastructure.processor;

import com.desafio.agibank.importalotes.domain.enums.DataType;
import com.desafio.agibank.importalotes.infrastructure.builder.ClientBuilder;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesBuilder;
import com.desafio.agibank.importalotes.infrastructure.builder.SalesmanBuilder;
import com.desafio.agibank.importalotes.infrastructure.dto.ReportDto;
import com.desafio.agibank.importalotes.infrastructure.helpers.FileReaderHelper;
import com.desafio.agibank.importalotes.infrastructure.reports.GeneratorReport;
import com.desafio.agibank.importalotes.infrastructure.service.ClientService;
import com.desafio.agibank.importalotes.infrastructure.service.SalesService;
import com.desafio.agibank.importalotes.infrastructure.service.SalesmanService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProcessImportFiles {

    private final FileReaderHelper fileReader;
    private final ClientBuilder clientBuilder;
    private final SalesmanBuilder salesmanBuilder;
    private final SalesBuilder salesBuilder;
    private final SalesService salesService;
    private final SalesmanService salesmanService;
    private final ClientService clientService;
    private final GeneratorReport generatorReport;

    public ProcessImportFiles(FileReaderHelper fileReader,
            ClientBuilder clientBuilder,
            SalesmanBuilder salesmanBuilder,
            SalesBuilder salesBuilder,
            SalesService salesService,
            SalesmanService salesmanService,
            ClientService clientService, GeneratorReport generatorReport) {
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
        HashMap<String, List<String>> stringListHashMap = fileReader.readFiles();

        for (Map.Entry<String, List<String>> entry : stringListHashMap.entrySet()) {
            clientService.clear();
            salesService.clear();
            salesmanService.clear();

            for (String line : entry.getValue()) {
                switch (DataType.getValue(line.substring(0, 3))) {
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

            generateReport(entry);
        }
    }

    private void generateReport(Map.Entry<String, List<String>> entry) throws IOException {
        generatorReport.generate(
                new ReportDto.Builder()
                        .clientsAmount(1)
                        .salesmanAmount(1)
                        .saleIdMoreExpensive("50")
                        .worstSeller("4545").build()
                , entry.getKey());
    }
}

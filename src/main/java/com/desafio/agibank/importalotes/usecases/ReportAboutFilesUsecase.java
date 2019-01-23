package com.desafio.agibank.importalotes.usecases;

import com.desafio.agibank.importalotes.infrastructure.processor.ProcessImportFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Usecase contendo processamento da importação dos arquivos.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:23:39
 */
@Component
public class ReportAboutFilesUsecase {

    private ProcessImportFiles processImportFiles;

    private static final Logger logger = LogManager.getLogger(ReportAboutFilesUsecase.class);

    @Autowired
    public void setProcessImportFiles(ProcessImportFiles processImportFiles) {
        this.processImportFiles = processImportFiles;
    }

    /**
     * Schedule que processa ao iniciar a aplicação e a cada 5 segundos, após o fim da execução anterior.
     */
    @Scheduled(fixedDelay = 5000, initialDelay = 0)
    public void generateReportAboutFiles() {

        logger.info("Starting the files processing");

        try {
            processImportFiles.run();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        logger.info("Finalized file reading process");
    }
}

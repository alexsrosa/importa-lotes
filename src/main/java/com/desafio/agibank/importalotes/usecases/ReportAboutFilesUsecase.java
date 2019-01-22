package com.desafio.agibank.importalotes.usecases;

import com.desafio.agibank.importalotes.infrastructure.processor.ProcessImportFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportAboutFilesUsecase {

    private ProcessImportFiles processImportFiles;

    private static final Logger logger = LogManager.getLogger(ReportAboutFilesUsecase.class);

    @Autowired
    public void setProcessImportFiles(ProcessImportFiles processImportFiles) {
        this.processImportFiles = processImportFiles;
    }

    @Scheduled(cron = "*/20 * * * * *")
    public void generateReport() {

        try {
            processImportFiles.run();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}

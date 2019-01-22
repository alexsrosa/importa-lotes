package com.desafio.agibank.importalotes.infrastructure.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileWriterHelper {

    private static final Logger logger = LogManager.getLogger(FileWriterHelper.class);

    @Value("${appconfig.file.out}")
    private String locationOut;

    public void write(String string, String fileName) throws IOException {

        logger.info("Creating a new file");

        fileName = getNameFile(fileName);

        BufferedWriter writer = new BufferedWriter(new FileWriter(locationOut.concat(fileName)));

        try {
            writer.write(string);
            writer.close();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        logger.info("The file ".concat(fileName).concat(" was created successfully!"));
    }

    private String getNameFile(String fileName) {
        String[] fileSplited = fileName.split(".");
        fileName = fileSplited[0].concat(".done").concat(fileSplited[1]);
        return fileName;
    }
}

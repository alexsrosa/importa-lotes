package com.desafio.agibank.importalotes.infrastructure.helpers;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe de ajuda para escrita em um novo arquivo.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:46:26
 */
@Component
public class FileWriterHelper {

    private static final Logger logger = LogManager.getLogger(FileWriterHelper.class);

    public void write(String location, String nameDone, String content, String fileName) {

        logger.info("Creating a new file");

        fileName = getNameFile(fileName, nameDone);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(location.concat(fileName)))) {
            writer.write(content);
        } catch (IOException e) {
            logger.error("Error: " + e.getMessage());
        }

        logger.info("The file ".concat(fileName).concat(" was created successfully!"));
    }

    private String getNameFile(String fileName, String nameDone) {
        return FilenameUtils.getBaseName(fileName)
                .concat(nameDone)
                .concat(FilenameUtils.getExtension(fileName));
    }
}

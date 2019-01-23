package com.desafio.agibank.importalotes.infrastructure.helpers;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Classe de ajuda para leitura de arquivos.
 *
 * @author <a href="mailto:alexsrosa@ntconsult.com.br">alexsrosa</a>
 * @since 23/01/2019 11:44:20
 */
@Component
public class FileReaderHelper {

    private static final Logger logger = LogManager.getLogger(FileReaderHelper.class);

    public HashMap<String, List<String>> readFiles(String location, String extensionPattern) {

        HashMap<String, List<String>> listFiles = new HashMap<>();

        for (File file : loadFiles(location)) {
            if (FilenameUtils.getExtension(file.getName()).equals(extensionPattern)) {
                listFiles.put(file.getName(), readFile(file));
            }
        }

        return listFiles;
    }

    private File[] loadFiles(String locationIn) {
        return new File(locationIn).listFiles();
    }

    private List<String> readFile(File file) {

        List<String> linhas = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(getInputStream(file)))) {
            String line;

            while (Objects.nonNull((line = buffer.readLine()))) {
                linhas.add(line);
            }
        } catch (IOException e) {
            logger.warn("Could not readFile file ".concat(file.getName()));
        }

        logger.info("The file ".concat(file.getName()).concat(" has been successfully readFile"));

        removeFile(file, file.getName());

        return linhas;
    }

    private InputStream getInputStream(File file) {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error("Files not Found!");
        }
        return in;
    }

    private void removeFile(File file, String fileName) {
        file.delete();
        logger.info("The file ".concat(fileName).concat(" was removed!"));
    }

}

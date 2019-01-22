package com.desafio.agibank.importalotes.infrastructure.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class FileReaderHelper {

    private static final Logger logger = LogManager.getLogger(FileReaderHelper.class);

    private final ResourceLoader resourceLoader;

    @Value("${appconfig.file.pattern}")
    private String locationPattern;

    public FileReaderHelper(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private List<Resource> loadResources() throws Exception {
        try {
            return Arrays.asList(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources(locationPattern));
        } catch (IOException e) {
            throw new Exception("No files found");
        }
    }

    public HashMap<String, List<String>> readFiles() throws Exception {

        logger.info("Starting the files processing");

        HashMap<String, List<String>> listFiles = new HashMap<>();

        for (Resource resource : loadResources()) {
            listFiles.put(resource.getFile().getName(), read(resource.getFile()));
        }

        logger.info("Finalized file reading process");

        return listFiles;
    }

    private List<String> read(File file) throws FileNotFoundException {

        String fileName = file.getName();

        List<String> linhas = new ArrayList<>();
        InputStream in = new FileInputStream(file);

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(in))) {
            String line;

            while ((line = buffer.readLine()) != null) {
                linhas.add(line);
            }
        } catch (IOException e) {
            logger.warn("Could not read file ".concat(file.getName()));
        }

        logger.info("The file ".concat(fileName).concat(" has been successfully read"));

        removeFile(file, fileName);

        return linhas;
    }

    private void removeFile(File file, String fileName) {
        file.delete();

        logger.info("The file ".concat(fileName).concat(" was removed!"));
    }

}

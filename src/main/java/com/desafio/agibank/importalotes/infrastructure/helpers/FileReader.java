package com.desafio.agibank.importalotes.infrastructure.helpers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    private static List<Resource> resources;
    private static ResourceLoader resourceLoader;

    public static List<Resource> loadResources() throws IOException {
        return Arrays.asList(
                ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                        .getResources("classpath:data/in/*.dat"));
    }

    public static void readFiles() throws IOException {

        loadResources().forEach(
                f -> {
                    try {
                        System.out.println(f.getFile().canRead());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("FIM");
    }
}

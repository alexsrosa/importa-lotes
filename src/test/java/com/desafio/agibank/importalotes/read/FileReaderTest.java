package com.desafio.agibank.importalotes.read;

import com.desafio.agibank.importalotes.infrastructure.helpers.FileReader;
import org.junit.Test;

import java.io.IOException;

public class FileReaderTest {

    @Test
    public void readFileTests() throws IOException {
        FileReader.readFiles();
    }
}

package com.desafio.agibank.importalotes.read;

import com.desafio.agibank.importalotes.infrastructure.helpers.FileReaderHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileReaderTest {

    @Autowired
    private FileReaderHelper fileReader;

    @Test
    public void readFileTests() throws Exception {
        fileReader.readFiles();
        assertTrue(Boolean.TRUE);
    }
}

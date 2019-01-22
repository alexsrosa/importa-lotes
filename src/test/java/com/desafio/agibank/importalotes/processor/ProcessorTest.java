package com.desafio.agibank.importalotes.processor;

import com.desafio.agibank.importalotes.infrastructure.processor.ProcessImportFiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessorTest {

    @Autowired
    private ProcessImportFiles processImportFiles;

    @Test
    public void processRunSuccess() throws Exception {
        processImportFiles.run();
        assertTrue(Boolean.TRUE);
    }
}

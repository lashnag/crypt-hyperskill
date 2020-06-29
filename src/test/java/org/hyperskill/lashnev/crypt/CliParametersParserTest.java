package org.hyperskill.lashnev.crypt;

import junit.framework.TestCase;
import java.io.IOException;
import java.nio.file.Path;

public class CliParametersParserTest extends TestCase {

    public void testGetIsEncrypt() throws IOException {
        CliParametersParser cliParametersParser = new CliParametersParser("-mode", "enc").invoke();
        assertTrue(cliParametersParser.getIsEncrypt());
    }

    public void testGetShift() throws IOException {
        CliParametersParser cliParametersParser = new CliParametersParser("-key", "5").invoke();
        assertEquals(5, cliParametersParser.getShift());
    }

    public void testGetToConvert() throws IOException {
        CliParametersParser cliParametersParser = new CliParametersParser("-data", "Welcome to hyperskill!").invoke();
        assertEquals("Welcome to hyperskill!", cliParametersParser.getToConvert());
    }

    public void testGetOutputFile() throws IOException {
        CliParametersParser cliParametersParser = new CliParametersParser("-out", "protected.txt").invoke();
        assertEquals(Path.of("protected.txt"), cliParametersParser.getOutputFile());
    }

    public void testGetAlgorithm() throws IOException {
        CliParametersParser cliParametersParser = new CliParametersParser("-alg", "unicode").invoke();
        assertEquals("unicode", cliParametersParser.getAlgorithm());
    }
}
package org.hyperskill.lashnev.crypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class CliParametersParser {

    private final String[] args;
    private boolean isEncryptParsed;
    private int shiftParsed;
    private String toConvertParsed;
    private String algorithm;
    private Path outputFile = null;

    public CliParametersParser(String... args) {
        this.args = args;
    }

    public boolean getIsEncrypt() {
        return isEncryptParsed;
    }

    public int getShift() {
        return shiftParsed;
    }

    public String getToConvert() {
        return toConvertParsed;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public CliParametersParser invoke() throws IOException {
        isEncryptParsed = true;
        shiftParsed = 0;
        toConvertParsed = "";
        algorithm = "shift";

        int parametersCount = args.length;
        for(int i=0; i < parametersCount; i++){
            if ("-mode".equals(args[i])) {
                isEncryptParsed = "enc".equals(args[i + 1]);
            }
            if ("-key".equals(args[i])) {
                shiftParsed = Integer.parseInt(args[i + 1]);
            }
            if ("-data".equals(args[i])) {
                toConvertParsed = args[i + 1];
            }
            if("-in".equals(args[i]) && toConvertParsed.length() == 0){
                toConvertParsed = Files.readString(Path.of(args[i + 1]));
            }
            if("-out".equals(args[i])){
                outputFile = Path.of(args[i + 1]);
            }
            if("-alg".equals(args[i])){
                algorithm = args[i + 1];
            }
        }
        return this;
    }
}

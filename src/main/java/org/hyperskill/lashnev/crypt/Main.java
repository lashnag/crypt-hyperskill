package org.hyperskill.lashnev.crypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String convertedString;
        CliParametersParser methodsParser = new CliParametersParser(args).invoke();

        Crypt crypt = getCrypt(methodsParser.getAlgorithm());
        if(methodsParser.getIsEncrypt()){
            convertedString = crypt.encrypt(
                methodsParser.getToConvert(),
                methodsParser.getShift()
            );
        }
        else {
            convertedString = crypt.decrypt(
                methodsParser.getToConvert(),
                methodsParser.getShift()
            );
        }

        Path outputPath = methodsParser.getOutputFile();
        if(outputPath != null){
            Files.write(outputPath, convertedString.getBytes());
        }
        else {
            System.out.println(convertedString);
        }
    }

    private static Crypt getCrypt(String algorithm){
        switch (algorithm){
            case "unicode":
                return new UnicodeCrypt();
            case "shift":
                return new AlphabetCrypt();
            default:
                throw new IllegalArgumentException();
        }
    }
}
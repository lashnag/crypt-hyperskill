package org.hyperskill.lashnev.crypt;

public class UnicodeCrypt implements Crypt{
    @Override
    public String encrypt(String data, int key) {
        int[] convertedArray = data.chars().map(symbol -> symbol + key).toArray();

        StringBuilder convertedString = new StringBuilder();
        for(int letter : convertedArray){
            convertedString.append((char) letter);
        }
        return convertedString.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        int[] convertedArray = data.chars().map(symbol -> symbol - key).toArray();

        StringBuilder convertedString = new StringBuilder();
        for(int letter : convertedArray){
            convertedString.append((char) letter);
        }
        return convertedString.toString();
    }
}

package org.hyperskill.lashnev.crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlphabetCrypt implements Crypt {

    private final List<String> englishUpperCaseAlphabet = new ArrayList(Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",")));
    private final List<String> englishLowerCaseAlphabet = new ArrayList(Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")));

    @Override
    public String encrypt(String data, int key) {
        int[] convertedArray = data.chars().map(symbol -> {
            String letterSymbol = String.valueOf((char)symbol);
            if(englishUpperCaseAlphabet.contains(letterSymbol)){
                int currentIndex = englishUpperCaseAlphabet.indexOf(letterSymbol);
                int newIndex = (currentIndex + key) % englishUpperCaseAlphabet.size();
                return englishUpperCaseAlphabet.get(newIndex).charAt(0);
            }
            if(englishLowerCaseAlphabet.contains(letterSymbol)){
                int currentIndex = englishLowerCaseAlphabet.indexOf(letterSymbol);
                int newIndex = (currentIndex + key) % englishLowerCaseAlphabet.size();
                return englishLowerCaseAlphabet.get(newIndex).charAt(0);
            }
            return symbol;
        }).toArray();

        StringBuilder convertedString = new StringBuilder();
        for(int letter : convertedArray){
            convertedString.append((char) letter);
        }
        return convertedString.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        int[] convertedArray = data.chars().map(symbol -> {
            String letterSymbol = String.valueOf((char)symbol);
            if(englishUpperCaseAlphabet.contains(letterSymbol)){
                int currentIndex = englishUpperCaseAlphabet.indexOf(letterSymbol);
                int newIndex = (englishUpperCaseAlphabet.size() + currentIndex - key) % englishUpperCaseAlphabet.size();
                return englishUpperCaseAlphabet.get(newIndex).charAt(0);
            }
            if(englishLowerCaseAlphabet.contains(letterSymbol)){
                int currentIndex = englishLowerCaseAlphabet.indexOf(letterSymbol);
                int newIndex = (englishUpperCaseAlphabet.size() + currentIndex - key) % englishLowerCaseAlphabet.size();
                return englishLowerCaseAlphabet.get(newIndex).charAt(0);
            }
            return symbol;
        }).toArray();

        StringBuilder convertedString = new StringBuilder();
        for(int letter : convertedArray){
            convertedString.append((char) letter);
        }
        return convertedString.toString();
    }
}

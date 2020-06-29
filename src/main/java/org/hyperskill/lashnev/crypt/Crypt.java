package org.hyperskill.lashnev.crypt;

public interface Crypt {
    String encrypt(String data, int key);
    String decrypt(String data, int key);
}

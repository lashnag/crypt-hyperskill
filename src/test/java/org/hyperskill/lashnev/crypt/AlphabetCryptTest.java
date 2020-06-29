package org.hyperskill.lashnev.crypt;

import junit.framework.TestCase;

public class AlphabetCryptTest extends TestCase {

    public void testEncrypt() {
        Crypt crypt = new AlphabetCrypt();
        String encodedString = crypt.encrypt("Welcome to hyperskill!", 5);
        assertEquals("Bjqhtrj yt mdujwxpnqq!", encodedString);
    }

    public void testDecrypt() {
        Crypt crypt = new AlphabetCrypt();
        String encodedString = crypt.decrypt("Bjqhtrj yt mdujwxpnqq!", 5);
        assertEquals("Welcome to hyperskill!", encodedString);
    }
}
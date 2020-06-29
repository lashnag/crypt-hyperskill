package org.hyperskill.lashnev.crypt;

import junit.framework.TestCase;

public class UnicodeCryptTest extends TestCase {

    public void testEncrypt() {
        Crypt crypt = new UnicodeCrypt();
        String encodedString = crypt.encrypt("Welcome to hyperskill!", 5);
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", encodedString);
    }

    public void testDecrypt() {
        Crypt crypt = new UnicodeCrypt();
        String encodedString = crypt.decrypt("\\jqhtrj%yt%m~ujwxpnqq&", 5);
        assertEquals("Welcome to hyperskill!", encodedString);
    }
}
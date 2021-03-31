package com.github.lucasrsa;

import com.github.lucasrsa.options.MainOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class AppTest {

    InputStream stdin;

    @Before
    public void setUp() {
        stdin = System.in;
    }

    @Test
    public void main() {
        String data = "INCORRECT\n" +
                "COLLECTION\nNEW\nCollection1\nDescription\nKeyword1\n\n" +
                "COLLECTION\nNEW\nCollection1\n" +
                "COLLECTION\nSUB\nCollection1\nSub-Collection1\nDescription\nKeyword1\n\n" +
                "COLLECTION\nSUB\nCollection1\nSub-Collection1\n" +
                "COLLECTION\nSUB\nCollection2\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct1\nPrice\n9.99\nDescription\nQuantity\n10\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct1\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection2\n" +
                "PRODUCT\nSAVE\nCollection2\n" +
                "PRODUCT\nLIST\n" +
                "PRODUCT\nSEARCH\nProduct1\n" +
                "PRODUCT\nSEARCH\nProduct2\n" +
                "PRODUCT\nINCORRECT\nRETURN\n" +
                "COLLECTION\nSEARCH\nCollection1\nSub-Collection1\nProduct1\n" +
                "COLLECTION\nSEARCH\nCollection1\nSub-Collection1\nProduct2\n" +
                "COLLECTION\nSEARCH\nCollection1\nSub-Collection2\n" +
                "COLLECTION\nSEARCH\nCollection2\n" +
                "COLLECTION\nPRODUCTS\nCollection1\n" +
                "COLLECTION\nPRODUCTS\nSub-Collection1\n" +
                "COLLECTION\nPRODUCTS\nCollection2\n" +
                "COLLECTION\nLIST\n" +
                "COLLECTION\nINCORRECT\nRETURN\n" +
                "EXIT\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        App.main(new String[]{});
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
    }

}
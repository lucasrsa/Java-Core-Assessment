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
                "COLLECTION\nSUB\nWrongCollection\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct1\nPrice\n9.99\nDescription\nQuantity\n10\nImage1\n\nTSHIRT\nColor1\nGender1\nWrongSize\nXXXL\nWrongSleeve\nLONG\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct2\nPrice\n19.99\nDescription\nQuantity\n20\nImage1\n\nSNEAKERS\nColor1\nGender1\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct3\nPrice\n29.99\nDescription\nQuantity\n30\nImage1\n\nPANTS\nColor1\nGender1\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct4\nPrice\n39.99\nDescription\nQuantity\n30\nImage1\n\nINCORRECT\n\n" +
                "PRODUCT\nSAVE\nCollection1\nSub-Collection1\nProduct1\n" +
                "PRODUCT\nSAVE\nCollection1\nWrongSub-Collection\n" +
                "PRODUCT\nSAVE\nWrongCollection\n" +
                "PRODUCT\nLIST\n" +
                "PRODUCT\nSEARCH\nProduct1\n" +
                "PRODUCT\nSEARCH\nWrongProduct\n" +
                "PRODUCT\nINCORRECT\nRETURN\n" +
                "COLLECTION\nSEARCH\nCollection1\nSub-Collection1\nProduct1\n" +
                "COLLECTION\nSEARCH\nCollection1\nSub-Collection1\nWrongProduct\n" +
                "COLLECTION\nSEARCH\nCollection1\nWrongSub-Collection\n" +
                "COLLECTION\nSEARCH\nWrongCollection\n" +
                "COLLECTION\nPRODUCTS\nCollection1\n" +
                "COLLECTION\nPRODUCTS\nSub-Collection1\n" +
                "COLLECTION\nPRODUCTS\nWrongCollection\n" +
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
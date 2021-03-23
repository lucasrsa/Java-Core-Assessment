package com.github.lucasrsa;

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
        String data = "";
        data += "SAVE\nTest\n9.99\nDescription\n100\nCategory\n";
        data += "SAVE\nTest\n";
        data += "SAVE\nTest2\nInvalid price\n9.99\nDescription2\nInvalid quantity\n200\nCategory2\n";
        data += "SEARCH\nTest\n";
        data += "SEARCH\nTest3\n";
        data += "Invalid option\n";
        data += "LIST\n";
        data += "EXIT\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        App.main(new String[]{});
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
    }

}
package com.github.lucasrsa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductOptionsTest {

    @Test
    public void describe() {
        assertEquals("save a new product.", ProductOptions.SAVE.describe());
        assertEquals("list all products.", ProductOptions.LIST.describe());
        assertEquals("search for a product by name.", ProductOptions.SEARCH.describe());
        assertEquals("exit the application.", ProductOptions.EXIT.describe());
    }

}
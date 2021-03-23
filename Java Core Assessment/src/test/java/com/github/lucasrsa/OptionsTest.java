package com.github.lucasrsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsTest {

    @Test
    public void describe() {
        assertEquals("save a new product.",Options.SAVE.describe());
        assertEquals("list all products.",Options.LIST.describe());
        assertEquals("search for a product by name.",Options.SEARCH.describe());
        assertEquals("exit the application.",Options.EXIT.describe());
    }

}
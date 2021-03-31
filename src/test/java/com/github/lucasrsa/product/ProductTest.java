package com.github.lucasrsa.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        this.product = new Product("Test");
        assertNotNull(this.product);
    }

    @Test
    public void testEquals() {
        assertEquals(new Product("Test"), this.product);
        assertFalse(this.product.equals("WrongTest"));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Product("Test").hashCode(),this.product.hashCode());
    }

    @After
    public void tearDown() {
        this.product = null;
        System.gc();
    }
}
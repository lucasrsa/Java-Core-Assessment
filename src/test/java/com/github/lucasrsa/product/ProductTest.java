package com.github.lucasrsa.product;

import com.github.lucasrsa.collection.MainCollection;
import com.github.lucasrsa.collection.SubCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private SubCollection subCollection;
    private Product product;

    @Before
    public void setUp() {
        MainCollection mainCollection = new MainCollection("Test");
        assertNotNull(mainCollection);
        this.subCollection = new SubCollection("Test", mainCollection);
        assertNotNull(this.subCollection);
        this.product = new Product("Test", this.subCollection);
        assertNotNull(this.product);
    }

    @Test
    public void testEquals() {
        assertEquals(new Product("Test", this.subCollection), this.product);
        assertFalse(this.product.equals("WrongTest"));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Product("Test", this.subCollection).hashCode(),this.product.hashCode());
    }

    @After
    public void tearDown() {
        this.product = null;
        this.subCollection = null;
        System.gc();
    }
}
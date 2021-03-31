package com.github.lucasrsa.collection;

import com.github.lucasrsa.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainCollectionTest {

    private MainCollection collection;

    @Before
    public void setUp() {
        this.collection = new MainCollection("Test");
        assertNotNull(this.collection);
    }

    @Test
    public void testEquals() {
        assertEquals(new MainCollection("Test"), this.collection);
        assertFalse(this.collection.equals("WrongTest"));
    }

    @Test
    public void testHashCode() {
        assertEquals(new MainCollection("Test").hashCode(),this.collection.hashCode());
    }

    @After
    public void tearDown() {
        this.collection = null;
        System.gc();
    }
}
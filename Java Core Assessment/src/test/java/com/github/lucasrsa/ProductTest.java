package com.github.lucasrsa;

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
    public void testGetName() {
        assertEquals("Test", this.product.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(0.0, this.product.getPrice(), 0.001);
    }

    @Test
    public void testGetDescription() {
        assertEquals("", this.product.getDescription());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(0, this.product.getQuantity());
    }

    @Test
    public void testGetCategory() {
        assertEquals("", this.product.getCategory());
    }

    @Test
    public void testSetPrice() {
        this.product.setPrice(14.49);
        assertEquals(14.49, this.product.getPrice(), 0.001);
    }

    @Test
    public void testSetDescription() {
        this.product.setDescription("Description");
        assertEquals("Description", this.product.getDescription());
    }

    @Test
    public void testSetQuantity() {
        this.product.setQuantity(1500);
        assertEquals(1500, this.product.getQuantity());
    }

    @Test
    public void testSetCategory() {
        this.product.setCategory("Category");
        assertEquals("Category", this.product.getCategory());
    }

    @Test
    public void testDescribe() {
//        final String str =  "Product: " + this.product.getName() + "\n\tPrice: $ "
//                + String.format("%.2f", this.product.getPrice()) + "\n\tDescription: "
//                + this.product.getDescription() + "\n\tQuantity: " + this.product.getQuantity()
//                + "\n\tCategory: " + this.product.getCategory();
//        assertEquals(str,this.product.describe());
    }

    @Test
    public void testToString() {
//        assertEquals(this.product.getName(),this.product.toString());
    }

    @Test
    public void testEquals() {
//        assertEquals(this.product, this.product);
    }

    @Test
    public void testHashCode() {
//        assertEquals(this.product.getName().hashCode(),this.product.hashCode());
    }

    @After
    public void tearDown() {
        this.product = null;
        System.gc();
    }
}
package com.github.lucasrsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product;
    private InputStream stdin;
    private Scanner scanner;

    @Before
    public void setUp() {
        this.stdin = System.in;
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
        this.scanner = new Scanner(System.in);
        this.product = new Product("Test", scanner);
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
    public void testDescribe() {
        final String str =  "Product: Test\n\tPrice: $ 0.00\n\tDescription: \n\tQuantity: 0\n\tCategory: ";
        assertEquals(str,this.product.describe());
    }

    @Test
    public void testToString() {
        assertEquals("Test",this.product.toString());
    }

    @Test
    public void testEquals() {
        assertEquals(new Product("Test", scanner), this.product);
    }

    @Test
    public void testHashCode() {
        assertEquals(new Product("Test", scanner).hashCode(),this.product.hashCode());
    }

    @After
    public void tearDown() {
        this.product = null;
        System.setIn(this.stdin);
        System.gc();
    }
}
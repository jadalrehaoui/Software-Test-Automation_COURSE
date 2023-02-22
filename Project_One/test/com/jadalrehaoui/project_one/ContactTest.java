package com.jadalrehaoui.project_one;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void testFieldRequired() {
        // Null values
        System.out.print("Checking for id = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("", "Jad", "Alrehaoui", "1234567890", "Golfito");
        });

        System.out.print("Checking for first name = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("123", "", "Alrehaoui", "1234567890", "Golfito");
        });

        System.out.print("Checking for last name = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("123", "Jad", "", "1234567890", "Golfito");
        });

        System.out.print("Checking for phone = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("123", "Jad", "Alrehaoui", "", "Golfito");
        });

        System.out.print("Checking for phone = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("123", "Jad", "Alrehaoui", "1234567890", "");
        });
    }

    @Test
    public void testFieldLength() {
        System.out.print("Checking for id > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345678901", "Jad", "Alrehaoui", "1234567890", "Golfito");
        });

        System.out.print("Checking for first name > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345", "Jad12345678", "Alrehaoui", "1234567890", "Golfito");
        });

        System.out.print("Checking for last name > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345", "Jad", "Alrehaoui12345421", "1234567890", "Golfito");
        });

        System.out.print("Checking for phone < 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345", "Jad", "Alrehaoui", "1234", "Golfito");
        });

        System.out.print("Checking for phone > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345", "Jad", "Alrehaoui", "12345678901", "Golfito");
        });

        System.out.print("Checking for address > 30 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345", "Jad", "Alrehaoui", "1234567890", "qwertyuiopasdfghjklzxcvbnmqwerty");
        });
    }

    @Test
    public void testGetters() {
        Contact c = new Contact("12345", "Jad", "Alrehaoui", "1234567890", "Golfito");
        assertEquals(c.getId(), "12345");
        assertEquals(c.getFirst_name(), "Jad");
        assertEquals(c.getLast_name(), "Alrehaoui");
        assertEquals(c.getPhone(), "1234567890");
        assertEquals(c.getAddress(), "Golfito");
    }

    @Test
    public void testSetters() {
        Contact c = new Contact("12345", "Jad", "Alrehaoui", "1234567890", "Golfito");
        c.setFirst_name("Rita");
        assertEquals(c.getFirst_name(), "Rita");
        c.setLast_name("Hassan");
        assertEquals(c.getLast_name(), "Hassan");
        c.setPhone("0987654321");
        assertEquals(c.getPhone(), "0987654321");
        c.setAddress("Lebanon");
        assertEquals(c.getAddress(), "Lebanon");
    }

    @Test
    public void testUpdateID() {
        Contact c = new Contact("12345", "Jad", "Alrehaoui", "1234567890", "Golfito");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setId("123");
        });
    }



}
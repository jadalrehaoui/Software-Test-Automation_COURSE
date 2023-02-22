package com.jadalrehaoui.project_one;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void testFieldRequired() {
        // Null values
        System.out.print("Checking for id = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("", "Laundry", "Do laundry @ 2PM");
        });

        System.out.print("Checking for name = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("1234", "", "Do laundry @ 2PM");
        });

        System.out.print("Checking for description = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("1234", "Laundry", "");
        });
    }

    @Test
    public void testFieldLength() {
        System.out.print("Checking for id > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("12345678901", "Laundry", "Do laundry @ 2PM");
        });

        System.out.print("Checking for name > 20 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("123", "Laundrysd wasdasdf vasmdad", "Do laundry @ 2PM");
        });

        System.out.print("Checking for description > 50 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("1234", "Laundry", "Do laundry @ 2PM + Fix something to eat, then work work work !!!");
        });
    }

    @Test
    public void testGetters() {
        Task t = new Task("12345", "Laundry", "Do laundry @ 2PM");
        assertEquals(t.getId(), "12345");
        assertEquals(t.getName(), "Laundry");
        assertEquals(t.getDescription(), "Do laundry @ 2PM");
    }

    @Test
    public void testSetters() {
        Task t = new Task("12345", "Laundry", "Do laundry @ 2PM");
        t.setName("Trash");
        assertEquals(t.getName(), "Trash");
        t.setDescription("Take out trash.");
        assertEquals(t.getDescription(), "Take out trash.");
    }

    @Test
    public void testUpdateID() {
        Task t = new Task("12345", "Laundry", "Do laundry @ 2PM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            t.setId("123");
        });
    }

}
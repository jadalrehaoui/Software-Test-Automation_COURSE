package com.jadalrehaoui.project_one;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService serv = new TaskService();

    @Test
    public void testCreateWithUniqueIDs() {
        for(int i = 0; i < 10; i++) {
            serv.create("id-"+ i, "Laundry-"+i, "Do laundry @ 2PM-" + i);
        }
        System.out.println(serv.toString());
        assertTrue(serv.getTasks().size() == 10);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testClearEntries() {

        serv.create("id", "name","desc");
        System.out.println("Size = " + serv.getTasks().size());
        serv.clearAllEntries();
        assertTrue(serv.getTasks().size() == 0);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testCreateWithDuplicateIDs() {
        serv.create("id", "name","desc");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.create("id", "name1","desc1");
        });
        assertTrue(serv.getTasks().size() == 1);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyName() {
        serv.create("id", "name","desc");
        assertEquals(serv.update("id", "Laundry", "").getName(), "Laundry");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyDescription() {
        serv.create("id", "name","desc");
        assertEquals(serv.update("id", "", "Do laundry @ 2PM").getDescription(), "Do laundry @ 2PM");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateIDNotFound() {
        serv.create("id", "name","desc");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.update("1", "", "Do laundry @ 2PM");
        });
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testDelete() {
        serv.create("id", "name","desc");
        assertEquals(serv.getTasks().size(),  1);
        serv.delete("id");
        assertEquals(serv.getTasks().size(), 0);
    }

    @Test
    public void testDeleteIDNotFound() {
        serv.create("id", "name","desc");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.delete("1");
        });
        // clean up
        serv.clearAllEntries();
    }
}
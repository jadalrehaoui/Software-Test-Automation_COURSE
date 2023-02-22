package com.jadalrehaoui.project_one;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class AppointmentServiceTest {
    private AppointmentService serv = new AppointmentService();
    @Test
    public void testCreateWithUniqueIDs() {
        for(int i = 0; i < 10; i++) {
            serv.create("id-"+ i, i+"-04-2023", "Doctor-"+i);
        }
        System.out.println(serv.toString());
        assertTrue(serv.getAppts().size() == 10);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testClearEntries() {
        serv.create("id", "04-04-2023","desc");
        System.out.println("Size = " + serv.getAppts().size());
        serv.clearAllEntries();
        assertTrue(serv.getAppts().size() == 0);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testCreateWithDuplicateIDs() {
        serv.create("id", "04-04-2023","desc");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.create("id", "04-04-2023","desc1");
        });
        assertTrue(serv.getAppts().size() == 1);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testDelete() {
        serv.create("id", "04-04-2023","desc");
        assertEquals(serv.getAppts().size(),  1);
        serv.delete("id");
        assertEquals(serv.getAppts().size(), 0);
    }

    @Test
    public void testDeleteIDNotFound() {
        serv.create("id", "04-04-2023","desc");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.delete("1");
        });
        // clean up
        serv.clearAllEntries();
    }

}
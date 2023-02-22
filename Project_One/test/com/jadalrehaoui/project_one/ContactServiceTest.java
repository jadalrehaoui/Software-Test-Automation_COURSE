package com.jadalrehaoui.project_one;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService serv = new ContactService();

    @Test
    public void testCreateWithUniqueIDs() {
        for(int i = 0; i < 10; i++) {
            serv.create("id-"+ i, "Jad-"+i, "Rehaoui-"+i, "407699017"+i, "Golfito-"+i);
        }
        System.out.println(serv.toString());
        assertTrue(serv.getContacts().size() == 10);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testClearEntries() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        System.out.println("Size = " + serv.getContacts().size());
        serv.clearAllEntries();
        assertTrue(serv.getContacts().size() == 0);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testCreateWithDuplicateIDs() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        });
        assertTrue(serv.getContacts().size() == 1);
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyFirstName() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        assertEquals(serv.update("id", "Rita", "", "","").getFirst_name(), "Rita");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyLastName() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        assertEquals(serv.update("id", "", "Hassan", "","").getLast_name(), "Hassan");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyPhone() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        assertEquals(serv.update("id", "", "", "4076681288","").getPhone(), "4076681288");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateOnlyAddress() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        assertEquals(serv.update("id", "", "", "","Beirut").getAddress(), "Beirut");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateAll() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        Contact c = serv.update("id", "Rita", "Hassan", "4076681288","Beirut");
        assertEquals(c.getAddress(), "Beirut");
        assertEquals(c.getPhone(), "4076681288");
        assertEquals(c.getLast_name(), "Hassan");
        assertEquals(c.getFirst_name(), "Rita");
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testUpdateIDNotFound() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.update("1", "Rita", "Hassan", "4076681288","Beirut");
        });
        // clean up
        serv.clearAllEntries();
    }

    @Test
    public void testDelete() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        assertEquals(serv.getContacts().size(),  1);
        serv.delete("id");
        assertEquals(serv.getContacts().size(), 0);
    }

    @Test
    public void testDeleteIDNotFound() {
        serv.create("id", "Jad", "Rehaoui", "4076990178", "Golfito");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            serv.delete("1");
        });
        // clean up
        serv.clearAllEntries();
    }
}
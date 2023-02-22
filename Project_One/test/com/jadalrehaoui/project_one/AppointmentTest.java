package com.jadalrehaoui.project_one;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentTest {
    private Date dateGenerator(String str){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testFieldRequired() {
        System.out.print("Checking for id = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("", dateGenerator("04-04-2023"), "qwerty");
        });

        System.out.print("Checking for date = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("123", null , "qwerty");
        });

        System.out.print("Checking for description = null =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("123", dateGenerator("04-04-2023"), "");
        });
    }

    @Test
    public void testInvalidDate() {
        System.out.print("Checking for date < now =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("123", dateGenerator("04-01-2023"), "qwerty");
        });
    }

    @Test
    public void testFieldLength() {
        System.out.print("Checking for id > 10 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("12345678901", dateGenerator("04-04-2023"), "qwerty");
        });

        System.out.print("Checking for descrition > 50 =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("123457890", dateGenerator("04-04-2023"), "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm");
        });
    }

    @Test
    public void testGetters() {
        Appointment appt = new Appointment("123", dateGenerator("04-04-2023"), "qwerty");
        assertEquals(appt.getId(), "123");
        assertEquals(appt.getDate(), dateGenerator("04-04-2023"));
        assertEquals(appt.getDescription(), "qwerty");
    }

    @Test
    public void testSetters() {
        Appointment appt = new Appointment("123", dateGenerator("04-04-2023"), "qwerty");
        appt.setDate(dateGenerator("04-12-2023"));
        assertEquals(appt.getDate(), dateGenerator("04-12-2023"));
        appt.setDescription("azerty");
        assertEquals(appt.getDescription(), "azerty");
    }

    @Test
    public void testUpdateID() {
        Appointment appt = new Appointment("123", dateGenerator("04-04-2023"), "qwerty");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appt.setId("1233");
        });
    }
}
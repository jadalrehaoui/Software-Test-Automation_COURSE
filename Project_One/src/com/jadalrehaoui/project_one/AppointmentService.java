package com.jadalrehaoui.project_one;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
//    declare array to hold all appointments
    private ArrayList<Appointment> appts = new ArrayList<Appointment>();
//    function to generate date as Date out of a string
    private Date dateGenerator(String str) {
//        SimpleDateFormat used to format the date as dd-MM-yyyy
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
//            parsing string to extract Data and return it
            return formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        unreachable but why not ?
        return null;
    }
//    Function to create appointment and add it to the array.
//    it checks if appointment id is already in the array
//    it keeps all id unique
    public void create(String id, String date, String description) {
//        checking if id exists
        if(find(id) == null) {
//            Initializing appointment with passed fields
            Appointment appt = new Appointment(id, dateGenerator(date), description);
//            adding it to the array
            appts.add(appt);
        } else {
//            if id exists =>
            System.out.println("ID already exists.");
            throw new IllegalArgumentException("Caught on ID\n\tDuplicate ID");
        }
    }
//    Function to remove appointment from array by ID
    public void delete(String id) {
//        finding the appointment with a given id
        Appointment temp = find(id);
//        if we have an appointment with that id =>
        if(temp != null) {
//            remove it
            appts.remove(temp);
//            print that it was removed
            System.out.println("Task has been removed.");
        } else {
//            if ID was not found in the array
            System.out.println("Appointment with ID "+ id + " was not found.");
            throw new IllegalArgumentException("Caught on ID = " + id +"\n\tNot Found.");
        }
    }
//    Function to return the array => used to get size and more.
    public ArrayList<Appointment> getAppts() {
        return appts;
    }
//    Function to find appointment in the array by ID
    private Appointment find(String id) {
//        looping through the array
        for(Appointment appt: appts) {
//            checking if id is equal to the iterated appt ID
            if(appt.getId().equals(id)) {
                return appt;
            }
        }
//        if not found =>
        return null;
    }
//    Function to return the array as a string, to see all records.
    public String toString() {
//        initializing the string to be returned
        String str = "";
//        looping through all appointments
        for(Appointment appt: appts) {
//            concatinating the string
            str += appt.toString() + "\n";
        }
//        return =>
        return str;
    }
//    for testing purposes
    public void clearAllEntries() {
        appts.removeIf(appt -> !appt.getId().equals(""));
    }
}

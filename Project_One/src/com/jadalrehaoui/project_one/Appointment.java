package com.jadalrehaoui.project_one;

import java.util.Date;

public class Appointment {
/*
Function that takes length, exact, numeric, required, the field, and the desired field name as arguments
     checks if the field meets requirements
     throws illegal argument exception if any of the requirement is not met
     returns true if all the requirements are met
*/
    private boolean stringValidator(int length, boolean exact, boolean numeric, boolean required, String field, String field_name) throws IllegalArgumentException {
        // null checker
        if(required) {
            if(field.equals("") || field == null || field.equals(null) || field.length() == 0) {
                System.out.println(field_name + " is required.");
                throw new IllegalArgumentException("Caught on " + field_name + "\n\tNULL");
            }
        }
        // exact length checker
        if(exact && field.length() != length) {
            System.out.println(field_name + " should be exactly " + length + " characters long.");
            throw new IllegalArgumentException("Caught on " + field_name + "\n\tLength not equal to " + length );
        }
        // exceeding length checker
        if(field.length() > length) {
            System.out.println(field_name + " should not be more than " + length + " characters long.");
            throw new IllegalArgumentException("Caught on " + field_name + "\n\tLength > Too long");

        }
        // numeric values checker
        if(numeric && !field.matches("[0-9]+")) {
            System.out.println(field_name + " should contain only numeric characters 0 -> 9 .");
            throw new IllegalArgumentException("Caught on " + field_name + "\n\tNot numeric");
        }
        // if no exception was thrown, this code will be reachable, and it will return true :)
        return true;
    }
/*
Function that takes in the future, required, the date field, and the desired date field name as arguments
     checks if the date meets requirements
     throws illegal argument exception if any of the requirement is not met
     returns true if all the requirements are met
     in the future argument is set to true when we want to validate the date to be in the future, now as a reference.
*/
    private boolean dateValidator(boolean in_the_future, boolean required, Date date, String date_name) throws IllegalArgumentException {
        //  null checker
        if(date == null) {
            System.out.println(date_name + " is required.");
            throw new IllegalArgumentException("Caught on " + date_name + "\n\tNULL");
        }
        // in the future checker
        if(in_the_future && date.before(new Date())) {
            System.out.println(date_name + " should be in the future.");
            throw new IllegalArgumentException("Caught on " + date_name + "\n\tShould be in the future.");
        }
        return true;
    }

//     Fields declarations #START#
    private String id; // <= 10 char // not updatable // required
    private Date date; // should be in the future // required
    private String description; // <= 50 char // required
//    Fields declarations #END#

/*
    Constructor uses validators to initialize the fields and throws exceptions caught from validators if req not met
*/
    public Appointment(String id, Date date, String description) {
//        checking ID
        if(stringValidator(10, false,false,true, id, "ID")){
            this.id = id;
        }
//        checking date
        if(dateValidator(true, true, date, "Date")) {
            this.date = date;
        }
//        checking description
        if(stringValidator(50, false, false, true, description, "Description")){
            this.description = description;
        }
    }
//    Getter and Setter for ID
    public String getId() {
        return id;
    }
    public void setId(String id) {
        // ID cannot be updated by requirement.
        System.out.println("ID cannot be changed.");
        throw new IllegalArgumentException("Caught on ID\n\tID cannot be changed");
    }
//    Getter and Setter for date
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        // checking for date when updating
        if(dateValidator(true, true, date, "Date")) {
            this.date = date;
        }
    }

//    Getter and Setter for description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        // checking for description when updating
        if(stringValidator(50, false, false, true, description, "Description")){
            this.description = description;
        }
    }
// To preview the task as a string
    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}

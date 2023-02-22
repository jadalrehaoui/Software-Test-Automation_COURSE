package com.jadalrehaoui.project_one;

public class Task {
/*
Function that takes length, exact, numeric, required, the field, and the desired field name as arguments
     checks if the field meets requirements
     throws illegal argument exception if any of the requirement is not met
     returns true if all the requirements are met
*/
    private boolean stringValidator(int length, boolean exact, boolean numeric, boolean required, String field, String field_name) throws IllegalArgumentException{
        // null checker
        if(required) {
            if(field.equals("") || field == null || field == "" || field.length() == 0) {
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
//    Field declaration #START#
    private String id; // <= 10 char // not updatable // required
    private String name; // <= 20 char // required
    private String description; // <= 50 char // required
//    Field declaration #END#
/*
    Constructor uses validators to initialize the fields and throws exceptions caught from validators if req not met
*/
    public Task(String id, String name, String description) {
//        validate ID
        if(stringValidator(10, false, false, true, id, "ID")) {
            this.id = id;
        }
//        validate name
        if(stringValidator(20, false, false, true, name, "Name")) {
            this.name = name;
        }
//        validate description
        if(stringValidator(50, false, false, true, description, "Description")){
            this.description = description;
        }
    }
//    Getter and Setter for ID
    public String getId() {
        return id;
    }
    public void setId(String id) {
//        ID is not updatable by requirement
        System.out.println("ID cannot be changed.");
        throw new IllegalArgumentException("Caught on ID\n\tID cannot be changed");
    }
//    Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
//        validate name
        if(stringValidator(20, false, false, true, name, "Name")) {
            this.name = name;
        }
    }
//    Getter and Setter for description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
//        validate description
        if(stringValidator(50, false, false, true, description, "Description")){
            this.description = description;
        }
    }
//    for previewing task as a string
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

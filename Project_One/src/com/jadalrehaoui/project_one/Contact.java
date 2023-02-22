package com.jadalrehaoui.project_one;

public class Contact {
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
    private String first_name; // <= 10 char // required
    private String last_name; // <= 10 char // required
    private String phone; // == 10 char => should be numbers // required
    private String address; // <= 30 char // required
//    Field declaration #END#

/*
    Constructor uses validators to initialize the fields and throws exceptions caught from validators if req not met
*/
    public Contact(String id, String first_name, String last_name, String phone, String address) {
//        check for id
        if(stringValidator(10, false, false, true, id, "ID")) {
            this.id = id;
        }
//        check for first name
        if(stringValidator(10, false, false, true, first_name, "First name")) {
            this.first_name = first_name;
        }
//        check for last name
        if(stringValidator(10, false, false, true, last_name, "Last name")) {
            this.last_name = last_name;
        }
//        check for phone
        if(stringValidator(10, true, true, true, phone, "Phone")) {
            this.phone = phone;
        }
//        check for address
        if(stringValidator(30, false, false, true, address, "Address")) {
            this.address = address;
        }
    }
//    Getter and Setter for ID
    public String getId() {
        return id;
    }
    public void setId(String id) {
//        ID cannot be changed by requirement
        System.out.println("ID cannot be changed.");
        throw new IllegalArgumentException("Caught on ID\n\tID cannot be changed");
    }
//    Getter and Setter for first name
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
//        validate first name
        if(stringValidator(10, false, false, true, first_name, "First name")) {
            this.first_name = first_name;
        }
    }
//    Getter and Setter for last name
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
//        validate last name
        if(stringValidator(10, false, false, true, last_name, "Last name")) {
            this.last_name = last_name;
        }
    }
//    Getter and Setter for phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
//        validate phone
        if(stringValidator(10, true, true, true, phone, "Phone")) {
            this.phone = phone;
        }
    }
//    Getter and Setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
//        validate address
        if(stringValidator(30, false, false, true, address, "Address")) {
            this.address = address;
        }
    }
//    for previewing contact as a string
    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

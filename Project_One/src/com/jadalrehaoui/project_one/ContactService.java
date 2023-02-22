package com.jadalrehaoui.project_one;

import java.util.ArrayList;

public class ContactService {
    private ArrayList<Contact> ctcts = new ArrayList<Contact>(); // array to hold all contacts

    public void create(String id, String fname, String lname, String phone, String address) { // function to create contact from args
        if(find(id) == null) { // checking if id already used
            Contact c = new Contact(id, fname, lname, phone, address); // initializing contact with args
            ctcts.add(c); // adding contact to array
        } else { // if id already in use
            System.out.println("ID already exists."); // print error
            throw new IllegalArgumentException("Caught on ID\n\tDuplicate ID"); // throw error
        }
    }

    public Contact update(String id, String fname, String lname, String phone, String address){ // function to update contact per ID
        Contact temp = find(id); // find contact per ID
        if(temp != null) { // if contact found
            if(!fname.isEmpty()) { // if fname is passed
                temp.setFirst_name(fname); // update first name
            }
            if(!lname.isEmpty()) { // if lname is passed
                temp.setLast_name(lname); // update last name
            }
            if(!phone.isEmpty()) { // if phone is passed
                temp.setPhone(phone); // update phone
            }
            if(!address.isEmpty()) { // if address is passed
                temp.setAddress(address); // update address
            }
            System.out.println("Updated contact\n" + temp.toString()); // print success
            return temp; // return contact
        } else { // if contact with id not found
            System.out.println("Contact with ID "+ id + " was not found."); // print error
            throw new IllegalArgumentException("Caught on ID = " + id +"\n\tNot Found."); // throw error
        }
    }
    public void delete(String id) { // function to delete contact from array
        Contact c = find(id); // finding contact
        if (c != null) { // if found
            ctcts.remove(c); // removing
        } else { // if not found
            System.out.println("Contact with ID " + id + " was not found."); // print error
            throw new IllegalArgumentException("Caught on ID = " + id + "\n\tNot Found."); // throw err
        }
    }
    public ArrayList<Contact> getContacts() { // function to get the array
        return ctcts;
    }
//    Previewing all contacts in the arrya
    public String toString() {
        String str = "";
        for(Contact c: ctcts) {
            str += c.toString() + "\n";
        }
        return str;
    }
    private Contact find(String id) { // function to find a contact per ID in array
        for(Contact c: ctcts) { // looping through array
            if(c.getId().equals(id)){ // checking if arg id == contact id in array
                return c; // returning contact
            }
        }
        return null; // if not found
    }
    //for testing purposes
    public void clearAllEntries() {
        ctcts.removeIf(c -> !c.getId().equals(""));
    }
}

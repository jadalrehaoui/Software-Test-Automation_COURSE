


# Software Test Automation 
JUnit Testing - Java
### Jad Alrehaoui
##### Setup & Configuration
For this project I used IntelliJ IDEA on mac. 
- I created a new Java project
- Once the project has been created nagivate to 
    - File > Project Structure > Libraries > + (add)
    - Search for junit in the search bar
    - find the junit:junit:4.13.2
    - add it hit apply
- Then in the Modules tab
    - Right click on the home dir and add new folder called tests
    - and select the tests and hit the tests button to make it green
- Then hit apply 

##### Troubleshooting
If you couldn't create a new class in src, go to project structure and select src and hit sources button.

### Project walkthough
This project consists of 3 classes and 3 services. One service for each class.
The classes are :
- Contact
- Appointment
- Task

The services are :
- ContactService
- AppointmentService
- TaskService

I created each class with the required fields and validate them in the constructor
Here's an example: 
```
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
```
Then after this code I have setters and getters for the contact.

### Testing
To create a test I simply create a class in the tests directory and import these:
```
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.text.ParseException;
import static org.junit.Assert.*;
```
because I will use them after.
and in the class I start defining methods to test the code I created before. 
I annotate each test method with the **@Test** annotation
Here's an example
```
@Test
    public void testInvalidDate() {
        System.out.print("Checking for date < now =>\t");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appt = new Appointment("123", dateGenerator("04-01-2023"), "qwerty");
        });
    }
```
In IntelliJ once this annotation is set, a play button will appear on the left that can run the function. 

# Conclusion and Reflection

The code I provided is well-commentated and functional.
Each function is explained by the comments and it is functional because all the black box tests I ran them through succeeded. 

I was given a project requirements, and from those requirements I had to build this project.
First I read clearly what is given and started brainstorming how this can function efficiently. 
Then I designed and drew some graphs to better visualize what I will be dealing with and testing if it works. 
After design came implementation, which became so easy after all these steps. It didn't take me long because I knew what I am doing and where I am heading. 

## Thanks for reading this ...

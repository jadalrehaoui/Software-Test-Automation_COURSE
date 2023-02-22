package com.jadalrehaoui.project_one;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;

public class TaskService {
//    declaring array that holds all tasks
    private ArrayList<Task> tasks = new ArrayList<Task>();
//    Function to check if ID already exist and adds task to the array
    public void create(String id, String name, String description){
//        checking if ID exist
        if(find(id) == null) { // if id does not exits
//            Initializing a task with arguments
            Task t = new Task(id, name, description);
//            adding task to array
            tasks.add(t);
//            printing success
            System.out.println("Task has been added.");
        } else { // if id exists
//            print that it exists
            System.out.println("ID already exists.");
//            throw error/exception
            throw new IllegalArgumentException("Caught on ID\n\tDuplicate ID");
        }
    }
//    Function to find task and update it
    public Task update(String id, String name, String description) {
//        finding task in array
        Task temp = find(id);
        if(temp != null){ // if task exists
            if(!name.equals("")) { // if name is not null
//                update name
                temp.setName(name);
            }
            if(!description.equals("")) { // if desc is not null
//                update desc
                temp.setDescription(description);
            }
//            print success
            System.out.println("Updated task\n" + temp.toString());
//            return task
            return temp;
        } else { // if id exist
//            print error
            System.out.println("Task with ID "+ id + " was not found.");
//            throw error/excpetion
            throw new IllegalArgumentException("Caught on ID = " + id +"\n\tNot Found.");
        }
    }
//    Function to delete task from array
    public void delete(String id) {
        Task temp = find(id); // finding task
        if(temp != null) { // if task exist with a given ID
            tasks.remove(temp); // remove it
            System.out.println("Task has been removed."); // print success
        } else { // if task id does not exists
            System.out.println("Task with ID "+ id + " was not found."); // print error
            throw new IllegalArgumentException("Caught on ID = " + id +"\n\tNot Found."); // throw it
        }
    }
//    Function that returns tasks array
    public ArrayList<Task> getTasks() {
        return tasks;
    }
//    Previewing all tasks
    public String toString() {
        String str = "";
        for(Task t: tasks) {
            str += t.toString() + "\n";
        }
        return str;
    }
//    Funtion to find a task in the array
    private Task find(String id) {
        for(Task t: tasks) { // looping through all the array
            if(t.getId().equals(id)) { // checking if id argument is equal to iterated task in array
                return t; // returning task
            }
        }
        return null; // not found
    }

    // for testing purposes
    public void clearAllEntries() {
        tasks.removeIf(task -> !task.getId().equals(""));
    }



}

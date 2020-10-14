/*
 ~To-do.java~
  The class which constructs an To-do object which stores the time of the to-do
  and its name.
*/


package model;

public class Todo {

    // FIELDS
    private String taskName;
    private int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
    public Todo(String eventName, int time) {
        this.taskName = eventName;
        this.time = time;
    }

    // GETTERS

    public String getTodoName() {
        return this.taskName;
    }

    public int getTime() {
        return this.time;
    }

}

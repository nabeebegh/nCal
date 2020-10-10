/*
 ~Date.java~
  The class which constructs a Date object which stores the month, day, and
  various user entries of types Event, Reminds, and TodoTask.
*/

package model;

import java.util.ArrayList;
import java.util.List;

public class Date {

    // FIELDS
    private Month month;
    private int day;
    private List<Event> eventList;        // user entry of events
    private List<Reminder> reminderList;  // user entry of reminders
    private List<TodoTask> todoList;      // user entry of to-do list tasks

    // EFFECTS: Constructs a day with a month, day, and empty lists for user entries.
    public Date(Month month, int day) {
        this.month = month;
        this.day = day;
        this.eventList = new ArrayList<>();
        this.reminderList = new ArrayList<>();
        this.todoList = new ArrayList<>();
    }

    // GETTERS
    public Month getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public List<Event> getEventList() {
        return this.eventList;
    }

    public List<Reminder> getReminderList() {
        return this.reminderList;
    }

    public List<TodoTask> todoList() {
        return this.todoList;
    }


    // MODIFIES: this
    // EFFECTS:  add an Event to the list of events for the day.
    public void addEvent() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS:  if event in eventList, removes remove from list, else print error statement.
    public void removeEvent() {

    }

    // MODIFIES: this
    // EFFECTS: adds a reminder to the list of reminders for the day.
    public void addReminder() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: if reminder in reminderList, remove from list, else print error statement.
    public void removeReminder() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds a tasks to the to-do list for the day
    public void addTodo() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: if task in to-do list, remove from list, else print error statement.
    public void removeTodo() {
        // stub
    }


}


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
    private List<Todo> todoList;      // user entry of to-do list tasks

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

    public List<Todo> getTodoList() {
        return this.todoList;
    }


    // MODIFIES: this
    // EFFECTS:  add an Event to the list of events for the day.
    public void addEvent(Event event) {
        eventList.add(event);
    }

    // MODIFIES: this
    // EFFECTS:  if event in eventList, remove from list and return true, else false.
    public boolean removeEvent(Event event) {
        if (eventList.contains(event)) {
            eventList.remove(event);
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a reminder to the list of reminders for the day.
    public void addReminder(Reminder reminder) {
        reminderList.add(reminder);
    }

    // MODIFIES: this
    // EFFECTS: if reminder in reminderList, remove from list and return true, else false.
    public boolean removeReminder(Reminder reminder) {
        if (reminderList.contains(reminder)) {
            reminderList.remove(reminder);
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a tasks to the to-do list for the day
    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    // MODIFIES: this
    // EFFECTS: if task in to-do list, remove from list and return true, else false..
    public boolean removeTodo(Todo todo) {
        if (todoList.contains(todo)) {
            todoList.remove(todo);
            return true;
        } else {
            return false;
        }
    }


}


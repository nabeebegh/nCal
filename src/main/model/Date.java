package model;

import exceptions.InvalidDayException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
 ~Date.java~
  The class which constructs a Date object which stores the month, day, and
  various user entries of types Event, Reminds, and TodoTask.
*/

public class Date {

    // FIELDS
    private Month month;
    private int day;
    private List<Event> eventList;        // user entry of events
    private List<Reminder> reminderList;  // user entry of reminders
    private List<Todo> todoList;          // user entry of to-do list tasks

    // EFFECTS: If (1 <= day <= Maximum Days) is not true, throw InvalidDayException
    //          Otherwise, construct a day with a month, day, and empty lists for user entries.
    public Date(Month month, int day) throws InvalidDayException {
        this.month = month;
        this.day = day;
        this.eventList = new ArrayList<>();
        this.reminderList = new ArrayList<>();
        this.todoList = new ArrayList<>();
        if (day < 1 || day > month.getNumberOfDays()) {
            throw new InvalidDayException();
        }
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

    // EFFECTS: returns Date object as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("month", month.toJson());
        json.put("day", day);
        json.put("events", eventsToJsonArray());
        json.put("reminders", remindersToJsonArray());
        json.put("todos", todosToJsonArray());
        return json;
    }

    // EFFECTS: returns eventList as a JSONArray
    private JSONArray eventsToJsonArray() {
        JSONArray jsonArray = new JSONArray();

        for (Event e : eventList) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns eventList as a JSONArray
    private JSONArray remindersToJsonArray() {
        JSONArray jsonArray = new JSONArray();

        for (Reminder r : reminderList) {
            jsonArray.put(r.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns todoList as a JSONArray
    private JSONArray todosToJsonArray() {
        JSONArray jsonArray = new JSONArray();
        for (Todo t : todoList) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

}
/*
 ~To-do.java~
  The class which constructs an To-do object which stores the time of the to-do
  and its name.
*/


package model;

import org.json.JSONObject;

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

    // EFFECTS: returns To-do object as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", taskName);
        json.put("time", time);
        return json;
    }

}

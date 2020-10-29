/*
 ~Event.java~
  The class which constructs an Reminder object which stores the time of the reminder
  and its name.
*/

package model;

import org.json.JSONObject;

public class Reminder {

    // FIELDS
    private String reminderName;
    private int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
    public Reminder(String eventName, int time) {
        this.reminderName = eventName;
        this.time = time;
    }

    // GETTERS

    public String getReminderName() {
        return this.reminderName;
    }

    public int getTime() {
        return this.time;
    }

    // EFFECTS: returns Reminder object as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", reminderName);
        json.put("time", time);
        return json;
    }

}

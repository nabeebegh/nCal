package model;

import org.json.JSONObject;

/*
 ~Event.java~
  The class which constructs an Event object which stores the time of the event
  and its name.
*/

public class Event {

    // FIELDS
    private String eventName;
    private int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
    // EFFECTS:  constructs Event with given name and time
    public Event(String eventName, int time) {
        this.eventName = eventName;
        this.time = time;
    }

    // GETTERS

    public String getEventName() {
        return this.eventName;
    }

    public int getTime() {
        return this.time;
    }

    // EFFECTS: returns Event object as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", eventName);
        json.put("time", time);
        return json;
    }

}

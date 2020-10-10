package model;

public class Event {

    // FIELDS
    String eventName;
    int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
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

}
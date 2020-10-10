package model;

public class Reminder {

    // FIELDS
    String reminderName;
    int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
    public Reminder(String eventName, int time) {
        this.reminderName = eventName;
        this.time = time;
    }

    // GETTERS

    public String getEventName() {
        return this.reminderName;
    }

    public int getTime() {
        return this.time;
    }

}

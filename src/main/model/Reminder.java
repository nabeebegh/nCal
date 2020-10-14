/*
 ~Event.java~
  The class which constructs an Reminder object which stores the time of the reminder
  and its name.
*/

package model;

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

}

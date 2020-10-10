package model;

public class TodoTask {

    // FIELDS
    String taskName;
    int time; // In 24HR format

    // REQUIRES: 0000 <= time <= 2359
    public TodoTask(String eventName, int time) {
        this.taskName = eventName;
        this.time = time;
    }

    // GETTERS

    public String getEventName() {
        return this.taskName;
    }

    public int getTime() {
        return this.time;
    }

}

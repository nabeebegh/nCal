package model;

import java.util.List;

public class Calendar {
    // CONSTANTS
    public static final Month JANUARY = new Month("January");
    public static final Month FEBRUARY = new Month("February");
    public static final Month MARCH = new Month("March");
    public static final Month APRIL = new Month("April");
    public static final Month MAY = new Month("May");
    public static final Month JUNE = new Month("June");
    public static final Month JULY = new Month("July");
    public static final Month AUGUST = new Month("August");
    public static final Month SEPTEMBER = new Month("September");
    public static final Month OCTOBER = new Month("October");
    public static final Month NOVEMBER = new Month("November");
    public static final Month DECEMBER = new Month("December");

    // FIELDS
    int year;
    List<Month> monthList;

    // EFFECTS: constructs a empty calendar for a given year
    public Calendar(int year) {
        this.year = year;
    }

    // GETTERS
    public int getYear() {
        return this.year;
    }

    // EFFECTS: creates a virtual representation of a calendar
    public void createCalendar() {

    }


}

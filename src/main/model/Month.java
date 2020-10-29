/*
 ~Month.java~
  The class which constructs an empty Month object and then
  allocates a correct amount of days to a month.
*/

package model;

import org.json.JSONObject;

public class Month {
    // CONSTANTS
    public static final int FULL_MONTH_DAYS = 31;
    public static final int MONTH_DAYS = 30;
    public static final int FEBRUARY_DAYS = 28;

    // FIELDS
    private String nameOfMonth;
    private int numberOfDays;

    // REQUIRES: nameOfMonth must be one of the twelve months in the gregorian calendar
    //           no abbreviations, first letter capital
    //           January, February, March, April, ...
    // EFFECTS:  Creates month with given name and then allocates correct amount of days
    public Month(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
        createMonth();
    }

    // GETTERS

    public String getNameOfMonth() {
        return this.nameOfMonth;
    }

    public int getNumberOfDays() {
        return this.numberOfDays;
    }

    // MODIFIES: this
    // EFFECTS: allocates correct amount of days for a given Month
    public void createMonth() {
        if ((nameOfMonth.equals("January") || ((nameOfMonth.equals("March")) || ((nameOfMonth.equals("May"))
                || (nameOfMonth.equals("July") || (nameOfMonth.equals("August") || (nameOfMonth.equals("October")
                || (nameOfMonth.equals("December"))))))))) {
            numberOfDays = FULL_MONTH_DAYS;
        } else if ((nameOfMonth.equals("April") || ((nameOfMonth.equals("June") || (nameOfMonth.equals("September")
                  || (nameOfMonth.equals("November"))))))) {
            numberOfDays = MONTH_DAYS;
        } else {
            numberOfDays = FEBRUARY_DAYS;
        }
    }

    // EFFECTS: returns Month object as a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("month", nameOfMonth);
        return json;
    }

}

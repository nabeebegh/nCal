/*
 ~Month.java~
  The class which constructs an empty Month object.
  Method(s) in this class can be used to allocate correct amount of days to a month.
*/

package model;

import java.util.List;

public class Month {
    // CONSTANTS
    public static final int FULL_MONTH_DAYS = 31;
    public static final int MONTH_DAYS = 30;
    public static final int FEBRUARY_DAYS = 28;

    // FIELDS
    String nameOfMonth;
    int numberOfDays;

    // REQUIRES: nameOfMonth must be one of the twelve months in the gregorian calendar
    //           no abbreviations, first letter capital
    //           January, February, March, April, ...
    // EFFECTS:  Specified month with no days
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

    // EFFECTS: allocates correct amount of days for a given Month
    public int createMonth() {
        return 0; // stub
    }
}

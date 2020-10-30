package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 ~ReminderTest.java~
  The class tests all the methods in ReminderTest.java
*/



public class ReminderTest {

    // FIELDS
    Reminder testReminder;

    @BeforeEach
    public void runBefore() {
        testReminder = new Reminder("Test Reminder", 1400);
    }

    @Test
    public void testConstructor() {
        assertEquals(testReminder.getReminderName(), "Test Reminder");
        assertEquals(testReminder.getTime(), 1400);
    }

}

/*
 ~DateTest.java~
  The class tests all the methods in Date.java
*/

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    // CONSTANTS (Single point of control to test various months and dates)
    private static String month = "January";
    private static int day = 14;

    // FIELDS
    Month testMonth;
    Date testDate;
    Event testEvent;
    Reminder testReminder;
    Todo testTodo;

    @BeforeEach
    public void runBefore(){
        testMonth = new Month(month);
        testDate = new Date(testMonth, day);
        testEvent = new Event("Test Event", 800);
        testReminder = new Reminder("Test Reminder", 1100);
        testTodo = new Todo("Test Todo", 1400);
    }

    @Test
    public void testConstructor(){
        assertEquals(month, (testDate.getMonth()).getNameOfMonth());
        assertEquals(day, testDate.getDay());
        assertEquals(0, (testDate.getEventList()).size());
        assertEquals(0, (testDate.getReminderList()).size());
        assertEquals(0, (testDate.getTodoList()).size());
    }

    @Test
    public void testAddEvent(){
        testDate.addEvent(testEvent); // Adds event to Date
        assertEquals(1, (testDate.getEventList().size()));
        assertEquals(testEvent, (testDate.getEventList()).get(0));
    }

    @Test
    public void testRemoveEvent(){
        testDate.addEvent(testEvent); // Adds event to date
        assertEquals(1, (testDate.getEventList().size()));
        assertEquals(testEvent, (testDate.getEventList()).get(0));

        assertTrue(testDate.removeEvent(testEvent)); // Removes event from date and tests to see method returns true
        assertEquals(0, (testDate.getEventList().size()));

        assertFalse(testDate.removeEvent(testEvent)); // Tests removal of element that is not in list
    }

    @Test
    public void testAddReminder(){
        testDate.addReminder(testReminder);
        assertEquals(1, (testDate.getReminderList().size()));
        assertEquals(testReminder, (testDate.getReminderList()).get(0));
    }

    @Test
    public void testRemoveReminder(){
        testDate.addReminder(testReminder);
        assertEquals(1, (testDate.getReminderList().size()));
        assertEquals(testReminder, (testDate.getReminderList()).get(0));

        assertTrue(testDate.removeReminder(testReminder)); // Removes reminder from date and tests to see method returns true
        assertEquals(0, (testDate.getReminderList().size()));

        assertFalse(testDate.removeReminder(testReminder)); // Tests removal of element that is not in list
    }

    @Test
    public void testAddTodo(){
        testDate.addTodo(testTodo);
        assertEquals(1, (testDate.getTodoList().size()));
        assertEquals(testTodo, (testDate.getTodoList()).get(0));
    }

    @Test
    public void testRemoveTodo(){
        testDate.addTodo(testTodo);
        assertEquals(1, (testDate.getTodoList().size()));
        assertEquals(testTodo, (testDate.getTodoList()).get(0));

        assertTrue(testDate.removeTodo(testTodo)); // Removes reminder from date and tests to see method returns true
        assertEquals(0, (testDate.getTodoList().size()));

        assertFalse(testDate.removeTodo(testTodo)); // Tests removal of element that is not in list
    }


}

package persistence;

import exceptions.InvalidDayException;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
 ~LoadCalendarTest.java~
  The class tests all the methods in LoadCalendarTest.java
*/

public class LoadCalendarTest extends JsonTest {

    @Test
    void testLoadCalendarNonExistentFile() {
        LoadCalendar reader = new LoadCalendar("./data/error.json");
        try {
           Date d = reader.read();
           fail("IOException expected");
        } catch (IOException e) {
            // pass
        } catch (InvalidDayException e) {
            fail("InvalidDayException was not expected.");
        }
    }

    @Test
    void testLoadCalendarEmptyDate() {
        LoadCalendar reader = new LoadCalendar("./data/TEST/testLoadCalendarEmptyDate.json");
        try {
            Date d = reader.read();
            assertEquals(1, d.getDay());
            assertEquals("January", d.getMonth().getNameOfMonth());
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (InvalidDayException e) {
            fail("InvalidDayException was not expected.");
        }
    }

    @Test
    void testLoadCalendarGeneralDate() {
        LoadCalendar reader = new LoadCalendar("./data/TEST/testLoadCalendarGeneralDate.json");
        try {
            Date d = reader.read();
            assertEquals(1, d.getDay());
            assertEquals("January", d.getMonth().getNameOfMonth());
            int day = d.getDay();
            Month month = d.getMonth();
            List<Event> eventList = d.getEventList();
            List<Reminder> reminderList = d.getReminderList();
            List<Todo> todoList = d.getTodoList();
            checkDate(day, month, eventList, reminderList, todoList, d);
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (InvalidDayException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testLoadCalendarTriesToLoadBadDate() {
        LoadCalendar reader = new LoadCalendar("./data/TEST/testLoadCalendarBadDate.json");
        try {
            Date d = reader.read();
        } catch (IOException e) {
            fail("IOException was not expected");
        } catch (InvalidDayException e) {
            // pass
        }
    }


}

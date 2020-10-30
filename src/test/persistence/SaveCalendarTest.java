package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
 ~SaveCalendarTest.java~
  The class tests all the methods in SaveCalendarTest.java
*/

public class SaveCalendarTest extends JsonTest {

    @Test
    void testSaveCalendarInvalidFile() {
        try {
            Month m = new Month("January");
            Date d = new Date(m, 1);
            SaveCalendar writer = new SaveCalendar("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testSaveCalendarEmptyDate() {
        try {
            Month m = new Month("January");
            Date d = new Date(m, 1);
            SaveCalendar writer = new SaveCalendar("./data/TEST/testSaveCalendarEmptyDate.json");
            writer.open();
            writer.write(d);
            writer.close();

            LoadCalendar reader = new LoadCalendar("./data/TEST/testSaveCalendarEmptyDate.json");
            d = reader.read();
            assertEquals(1, d.getDay());
            assertEquals("January", d.getMonth().getNameOfMonth());
            int day = d.getDay();
            Month month = d.getMonth();
            List<Event> eventList = d.getEventList();
            List<Reminder> reminderList = d.getReminderList();
            List<Todo> todoList = d.getTodoList();
            checkDate(day, month, eventList, reminderList, todoList, d);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testSaveCalendarGeneralDate() {
        try {
            Month m = new Month("January");
            Date d = new Date(m, 1);
            Event e = new Event("testEvent", 1400);
            Reminder r = new Reminder ("testReminder", 1500);
            Todo t = new Todo("testTodo", 1600);
            d.addEvent(e);
            d.addReminder(r);
            d.addTodo(t);
            SaveCalendar writer = new SaveCalendar("./data/TEST/testSaveCalendarGeneralDate.json");
            writer.open();
            writer.write(d);
            writer.close();

            LoadCalendar reader = new LoadCalendar("./data/TEST/testSaveCalendarGeneralDate.json");
            d = reader.read();
            assertEquals(1, d.getDay());
            assertEquals("January", d.getMonth().getNameOfMonth());
            int day = d.getDay();
            Month month = d.getMonth();
            List<Event> eventList = d.getEventList();
            List<Reminder> reminderList = d.getReminderList();
            List<Todo> todoList = d.getTodoList();
            checkDate(day, month, eventList, reminderList, todoList, d);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}

package persistence;

import model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 ~JsonTest.java~
  This abstract class contains implementation for testing method(s) that are used in
  LoadCalendarTest and SaveCalendarTest. Both LoadCalendarTest and SaveCalendarTest extend
  JsonTest.
*/

public abstract class JsonTest {
    protected void checkDate(int day, Month month, List<Event> eventList, List<Reminder> reminderList,
                             List<Todo> todoList, Date d) {
        assertEquals(day, d.getDay());
        assertEquals(month, d.getMonth());
        assertEquals(eventList, d.getEventList());
        assertEquals(reminderList, d.getReminderList());
        assertEquals(todoList, d.getTodoList());
    }
}

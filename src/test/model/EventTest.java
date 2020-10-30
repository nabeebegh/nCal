package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 ~EventTest.java~
  The class tests all the methods in Event.java
*/


public class EventTest {

    // FIELDS
    Event testEvent;

    @BeforeEach
    public void runBefore() {
        testEvent = new Event("Test Event", 1400);
    }

    @Test
    public void testConstructor() {
        assertEquals(testEvent.getEventName(), "Test Event");
        assertEquals(testEvent.getTime(), 1400);
    }

}

/*
 ~TodoTest.java~
  The class tests all the methods in To-do.java
*/

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    // FIELDS
    Todo testTodo;

    @BeforeEach
    public void runBefore() {
        testTodo = new Todo("Test Todo", 1400);
    }

    @Test
    public void testConstructor() {
        assertEquals(testTodo.getTodoName(), "Test Todo");
        assertEquals(testTodo.getTime(), 1400);
    }

}

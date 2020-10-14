package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 ~MonthTest.java~
  The class tests all the methods in Month.java
*/

public class MonthTest {

    // FIELDS
    Month testMonth;

    @Test
    public void testConstructorJanuary() {
        testMonth = new Month("January");
        assertEquals("January", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorFebruary() {
        testMonth = new Month("February");
        assertEquals("February", testMonth.getNameOfMonth());
        assertEquals(28, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorMarch() {
        testMonth = new Month("March");
        assertEquals("March", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorApril() {
        testMonth = new Month("April");
        assertEquals("April", testMonth.getNameOfMonth());
        assertEquals(30, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorMay() {
        testMonth = new Month("May");
        assertEquals("May", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorJune() {
        testMonth = new Month("June");
        assertEquals("June", testMonth.getNameOfMonth());
        assertEquals(30, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorJuly() {
        testMonth = new Month("July");
        assertEquals("July", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorAugust() {
        testMonth = new Month("August");
        assertEquals("August", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorSeptember() {
        testMonth = new Month("September");
        assertEquals("September", testMonth.getNameOfMonth());
        assertEquals(30, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorOctober() {
        testMonth = new Month("October");
        assertEquals("October", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorNovember() {
        testMonth = new Month("November");
        assertEquals("November", testMonth.getNameOfMonth());
        assertEquals(30, testMonth.getNumberOfDays());
    }

    @Test
    public void testConstructorDecember() {
        testMonth = new Month("December");
        assertEquals("December", testMonth.getNameOfMonth());
        assertEquals(31, testMonth.getNumberOfDays());
    }
}

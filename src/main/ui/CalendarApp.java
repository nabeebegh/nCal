package ui;

import model.*;
import persistence.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// nCal application
public class CalendarApp {

    // CONSTANTS
    private static final Month JANUARY = new Month("January");
    private static final Month FEBRUARY = new Month("February");
    private static final Month MARCH = new Month("March");
    private static final Month APRIL = new Month("April");
    private static final Month MAY = new Month("May");
    private static final Month JUNE = new Month("June");
    private static final Month JULY = new Month("July");
    private static final Month AUGUST = new Month("August");
    private static final Month SEPTEMBER = new Month("September");
    private static final Month OCTOBER = new Month("October");
    private static final Month NOVEMBER = new Month("November");
    private static final Month DECEMBER = new Month("December");
    private static final String JSON_STORE = "./data/";

    // FIELDS
    private Scanner input;
    private List<Date> daysInJanuary;
    private List<Date> daysInFebruary;
    private List<Date> daysInMarch;
    private List<Date> daysInApril;
    private List<Date> daysInMay;
    private List<Date> daysInJune;
    private List<Date> daysInJuly;
    private List<Date> daysInAugust;
    private List<Date> daysInSeptember;
    private List<Date> daysInOctober;
    private List<Date> daysInNovember;
    private List<Date> daysInDecember;
    private LoadCalendar loadCalendar;
    private SaveCalendar saveCalendar;


    public void instantiateListofDates(){
        daysInJanuary = new ArrayList<>();
        daysInFebruary = new ArrayList<>();
        daysInMarch = new ArrayList<>();
        daysInApril = new ArrayList<>();
        daysInMay = new ArrayList<>();
        daysInJune = new ArrayList<>();
        daysInJuly = new ArrayList<>();
        daysInAugust = new ArrayList<>();
        daysInSeptember = new ArrayList<>();
        daysInOctober = new ArrayList<>();
        daysInNovember = new ArrayList<>();
        daysInDecember = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in for specified month with list size being the
    //          amount of days in that month.
    public void createMonth(List<Date> l, Month m) {
        for (int i = 1; i <= m.getNumberOfDays(); i++) {
            Date date = new Date(m, i);
            l.add(date);
        }
    }

    // EFFECTS: runs nCal application
    public CalendarApp() {
        instantiateListofDates();
        createMonth(daysInJanuary, JANUARY);
        createMonth(daysInFebruary, FEBRUARY);
        createMonth(daysInMarch, MARCH);
        createMonth(daysInApril, APRIL);
        createMonth(daysInMay, MAY);
        createMonth(daysInJune, JUNE);
        createMonth(daysInJuly, JULY);
        createMonth(daysInAugust, AUGUST);
        createMonth(daysInSeptember, SEPTEMBER);
        createMonth(daysInOctober, OCTOBER);
        createMonth(daysInNovember, NOVEMBER);
        createMonth(daysInDecember, DECEMBER);
        runCalendar();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runCalendar() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayMainMenu();
            input = new Scanner(System.in);
            command = input.next();
            input.useDelimiter("\n");
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // EFFECTS: prints user options for main menu
    public void displayMainMenu() {
        System.out.println("\nWelcome to nCal's Main Menu. Select from the following options:");
        System.out.println("\tv -> view calendar");
        System.out.println("\tsv -> save calendar");
        System.out.println("\tld -> load calendar");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: prints user options for month choices
    public void displayMonthChoices() {
        System.out.println("\nPlease select a month:");
        System.out.println("\tj -> January");
        System.out.println("\tf -> February");
        System.out.println("\tm -> March");
        System.out.println("\ta -> April");
        System.out.println("\tma -> May");
        System.out.println("\tje -> June");
        System.out.println("\tjl -> July");
        System.out.println("\tau -> August");
        System.out.println("\ts -> September");
        System.out.println("\to -> October");
        System.out.println("\tn -> November");
        System.out.println("\td -> December");
        System.out.println("\tany key -> return to main menu");
    }

    // EFFECTS: prints user options for month options
    public void displayMonthMenu() {
        System.out.println("\nHere is your calendar! Please choose one of the options below:");
        System.out.println("\tae -> add event");
        System.out.println("\tre -> remove event");
        System.out.println("\tar -> add reminder");
        System.out.println("\trr -> remove reminder");
        System.out.println("\tat -> add todo");
        System.out.println("\trt -> remove todo");
        System.out.println("\tany key -> return to main menu");
    }

    // EFFECTS: returns String of events for given day of a specified month
    public String returnEvent(Date date) {
        String string = "";
        for (int i = 0; (i <= date.getEventList().size() - 1); i++) {
            string = string + ((date.getEventList().get(i).getEventName()) + " @ "
                    + (date.getEventList().get(i).getTime())
                    + ", ");
        }
        return (string);
    }

    // EFFECTS: returns String of reminders for given day of a specified month
    public String returnReminder(Date date) {
        String string = "";
        for (int i = 0; (i <= date.getReminderList().size() - 1); i++) {
            string = string + ((date.getReminderList().get(i).getReminderName()) + "@"
                    + (date.getReminderList().get(i).getTime())
                    + ", ");
        }
        return (string);
    }

    // EFFECTS: returns String of tasks for given day of a specified month
    public String returnTodo(Date date) {
        String string = "";
        for (int i = 0; (i <= date.getTodoList().size() - 1); i++) {
            string = string + ((date.getTodoList().get(i).getTodoName()) + "@"
                    + (date.getTodoList().get(i).getTime())
                    + ", ");
        }
        return (string);
    }

    // MODIFIES: this
    // EFFECTS: processes user input, displays month choices, and then prints chosen month
    public void processCommand(String command) {
        if (command.equals("v")) {
            displayMonthChoices();
            command = input.next();
            processCommand(command);
        } else if (command.equals("j")) {
            printMonth(daysInJanuary, "January");
        } else if (command.equals("f")) {
            printMonth(daysInFebruary, "February");
        } else if (command.equals("m")) {
            printMonth(daysInMarch, "March");
        } else if (command.equals("a")) {
            printMonth(daysInApril, "April");
        } else if (command.equals("ma")) {
            printMonth(daysInMay, "May");
        } else if (command.equals("je")) {
            printMonth(daysInJune,"June");
        } else if (command.equals("jl")) {
            printMonth(daysInJuly, "July");
        } else {
            processCommandContinued(command);
        }
    }

    // EFFECTS: returns amount of digits in some integer i
    public int numLength(int i) {
        return String.valueOf(i).length();
    }

    // EFFECTS: processes user input, and prints chosen month
    public void processCommandContinued(String command) {
        if (command.equals("au")) {
            printMonth(daysInAugust, "August");
        } else if (command.equals("s")) {
            printMonth(daysInSeptember, "September");
        }  else if (command.equals("o")) {
            printMonth(daysInOctober, "October");
        } else if (command.equals("n")) {
            printMonth(daysInNovember, "November");
        } else if (command.equals("d")) {
            printMonth(daysInDecember, "December");
        } else if (command.equals("sv")) {
            saveAllMonths();
        } else if (command.equals("ld")) {
            loadAllMonths();
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: adds an event for a given date in the list of days in the month
    public void ae(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter event name: ");
            String name = input.next();
            System.out.println("Enter event time [24 hour format]: ");
            String timeString = input.next();
            int time = Integer.parseInt(timeString);
            if (!(time > 0 && time < 2400 && numLength(time) == 4)) {
                System.out.println("Please enter correct time.");
            } else {
                Event event = new Event(name, time);
                l.get(day - 1).addEvent(event);
                System.out.println("Event has been added.");
            }
        } else {
            System.out.println("Please choose a correct day!");
            ae(l);
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: adds a reminder for a given date in the list of days in the month
    public void ar(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter reminder name: ");
            String name = input.next();
            System.out.println("Enter reminder time [24 hour format]: ");
            String timeString = input.next();
            int time = Integer.parseInt(timeString);
            if (!(time > 0 && time < 2400 && numLength(time) == 4)) {
                System.out.println("Please enter correct time.");
            } else {
                Reminder reminder = new Reminder(name, time);
                l.get(day - 1).addReminder(reminder);
                System.out.println("Reminder has been added.");
            }
        } else {
            System.out.println("Please choose a correct day!");
            ar(l);
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: adds a task for a given date in the list of days in the month
    public void at(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter task name: ");
            String name = input.next();
            System.out.println("Enter task time [24 hour format]: ");
            String timeString = input.next();
            int time = Integer.parseInt(timeString);
            if (!(time > 0 && time < 2400 && numLength(time) == 4)) {
                System.out.println("Please enter correct time.");
            } else {
                Todo todo = new Todo(name, time);
                l.get(day - 1).addTodo(todo);
                System.out.println("Task has been added.");
            }
        } else {
            System.out.println("Please choose a correct day!");
            at(l);
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: removes an event from given date in the list of days in the month
    public void re(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter event number: (First item added is 1, second item added is 2, etc.)");
            String eventNumberString = input.next();
            int eventNumber = Integer.parseInt(eventNumberString);
            if (eventNumber >= 1 && eventNumber <= l.get(day - 1).getEventList().size()) {
                if (!(l.get(day - 1).getEventList().isEmpty())) {
                    l.get(day - 1).getEventList().remove(l.get(day - 1).getEventList().get(eventNumber - 1));
                    System.out.println("Event has been removed");
                } else {
                    System.out.println("Specified event does not exist. Please try again.");
                }
            } else {
                System.out.println("Specified event does not exist. Please try again.");
            }
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: removes a reminder from a given date in the list of days in the month
    public void rr(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter reminder number: (First item added is 1, second item added is 2, etc.)");
            String reminderNumberString = input.next();
            int reminderNumber = Integer.parseInt(reminderNumberString);
            if (reminderNumber >= 1 && reminderNumber <= l.get(day - 1).getReminderList().size()) {
                if (!((l.get(day - 1).getReminderList().isEmpty()))) {
                    l.get(day - 1).getReminderList().remove(l.get(day - 1).getReminderList().get(reminderNumber - 1));
                    System.out.println("Reminder has been removed");
                } else {
                    System.out.println("Specified reminder does not exist. Please try again.");
                }
            }
        } else {
            System.out.println("Specified reminder does not exist. Please try again.");
        }
    }

    // MODIFIES: this, List<Date> l
    // EFFECTS: removes a task from a given date in the list of days in the month
    public void rt(List<Date> l) {
        System.out.println("Choose a day [1 - " + (l.get(1).getMonth().getNumberOfDays()) + "]");
        String dayString = input.next();
        int day = Integer.parseInt(dayString);
        if (day <= (l.get(1).getMonth().getNumberOfDays()) && day >= 1) {
            System.out.println("Enter todo number: (First item added is 1, second item added is 2, etc.)");
            String todoNumberString = input.next();
            int todoNumber = Integer.parseInt(todoNumberString);
            if (todoNumber >= 1 && todoNumber <= l.get(day - 1).getTodoList().size()) {
                if (!(l.get(day - 1).getTodoList().isEmpty())) {
                    l.get(day - 1).getTodoList().remove(l.get(day - 1).getTodoList().get(todoNumber - 1));
                    System.out.println("task has been removed");
                } else {
                    System.out.println("Specified task does not exist. Please try again.");
                }
            } else {
                System.out.println("Specified task does not exist. Please try again.");
            }
        }
    }

    // EFFECTS: processes command and forwards user to specified month function
    public void processMonthCommand(String command, List<Date> l) {
        if (command.equals("ae")) {
            ae(l);
        } else if (command.equals("ar")) {
            ar(l);
        } else if (command.equals("at")) {
            at(l);
        } else if (command.equals("re")) {
            re(l);
        } else if (command.equals("rr")) {
            rr(l);
        } else if (command.equals("rt")) {
            rt(l);
        }
    }

    // EFFECTS: prints month, along with its events, reminders, and todos for each day in the month.
    public void printMonth(List<Date> d, String str) {
        System.out.println("-------------------" + str + "-------------------");
        for (int i = 0; i <= (d.size() - 1); i++) {
            System.out.println((((d.get(i)).getMonth()).getNameOfMonth()) + " "
                    + d.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(d.get(i)));
            System.out.println("\tReminders: " + returnReminder(d.get(i)));
            System.out.println("\tTodos: " + returnTodo(d.get(i)));
        }
        displayMonthMenu();
        String command = null;
        command = input.next();
        processMonthCommand(command, d);
    }

    // EFFECTS: returns save file link for given month and specific day of the month
    public String writeFileLink(String a, int b) {
        return ("./data/" + a + "/" + b + ".json");
    }

    // EFFECTS: saves all months to JSON save files
    public void saveAllMonths() {
        saveMonth(daysInJanuary, "jan");
        saveMonth(daysInFebruary, "feb");
        saveMonth(daysInMarch, "mar");
        saveMonth(daysInApril, "apr");
        saveMonth(daysInMay, "may");
        saveMonth(daysInJune, "jun");
        saveMonth(daysInJuly, "jul");
        saveMonth(daysInAugust, "aug");
        saveMonth(daysInSeptember, "sep");
        saveMonth(daysInOctober, "oct");
        saveMonth(daysInNovember, "nov");
        saveMonth(daysInDecember, "dec");
        System.out.println("Calendar has been saved.");
    }

    // EFFECTS: loads all months from JSON save files
    public void loadAllMonths() {
        loadMonth(daysInJanuary, "jan");
        loadMonth(daysInFebruary, "feb");
        loadMonth(daysInMarch, "mar");
        loadMonth(daysInApril, "apr");
        loadMonth(daysInMay, "may");
        loadMonth(daysInJune, "jun");
        loadMonth(daysInJuly, "jul");
        loadMonth(daysInAugust, "aug");
        loadMonth(daysInSeptember, "sep");
        loadMonth(daysInOctober, "oct");
        loadMonth(daysInNovember, "nov");
        loadMonth(daysInDecember, "dec");
        System.out.println("Previous save file has been load to calendar.");
    }

    // EFFECTS: load each date object for specified month from list of dates from their respective
    //          JSON save files
    public void loadMonth(List<Date> l, String str) {
        for (int i = 0; i < l.size(); i++) {
            loadCalendar = new LoadCalendar(writeFileLink(str, (i + 1)));
            try {
                Date d = l.get(i);
                d = loadCalendar.read();
                l.remove(1);
                l.add(d);
            } catch (IOException e) {
                System.out.println("Unable to load data from: " + JSON_STORE + "/" + str);
            }
        }
    }

    // EFFECTS: save each date object for specified month from list of dates to their respective
    //          JSON save files
    public void saveMonth(List<Date> d, String str) {
        for (int i = 0; i < d.size(); i++) {
            saveCalendar = new SaveCalendar(writeFileLink(str, (i + 1)));
            try {
                saveCalendar.open();
                saveCalendar.write(d.get(i));
                saveCalendar.close();
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write date to: " + JSON_STORE + "/" + str);
            }
        }
    }

}
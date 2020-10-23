package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// nCal application
public class CalendarApp {

    // CONSTANTS
    public static final Month JANUARY = new Month("January");
    public static final Month FEBRUARY = new Month("February");
    public static final Month MARCH = new Month("March");
    public static final Month APRIL = new Month("April");
    public static final Month MAY = new Month("May");
    public static final Month JUNE = new Month("June");
    public static final Month JULY = new Month("July");
    public static final Month AUGUST = new Month("August");
    public static final Month SEPTEMBER = new Month("September");
    public static final Month OCTOBER = new Month("October");
    public static final Month NOVEMBER = new Month("November");
    public static final Month DECEMBER = new Month("December");

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




    // INITIALIZE MONTHS FOR CALENDAR

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInJanuary for correct amount of days in month.
    public void createJanuary() {
        daysInJanuary = new ArrayList<>();
        for (int i = 1; i <= JANUARY.getNumberOfDays(); i++) {
            Date date = new Date(JANUARY, i);
            daysInJanuary.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInFebruary for correct amount of days in month.
    public void createFebruary() {
        daysInFebruary = new ArrayList<>();
        for (int i = 1; i <= FEBRUARY.getNumberOfDays(); i++) {
            Date date = new Date(FEBRUARY, i);
            daysInFebruary.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInMarch for correct amount of days in month.
    public void createMarch() {
        daysInMarch = new ArrayList<>();
        for (int i = 1; i <= MARCH.getNumberOfDays(); i++) {
            Date date = new Date(MARCH, i);
            daysInMarch.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInApril for correct amount of days in month.
    public void createApril() {
        daysInApril = new ArrayList<>();
        for (int i = 1; i <= APRIL.getNumberOfDays(); i++) {
            Date date = new Date(APRIL, i);
            daysInApril.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInMay for correct amount of days in month.
    public void createMay() {
        daysInMay = new ArrayList<>();
        for (int i = 1; i <= MAY.getNumberOfDays(); i++) {
            Date date = new Date(MAY, i);
            daysInMay.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInJune for correct amount of days in month.
    public void createJune() {
        daysInJune = new ArrayList<>();
        for (int i = 1; i <= JUNE.getNumberOfDays(); i++) {
            Date date = new Date(JUNE, i);
            daysInJune.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInJuly for correct amount of days in month.
    public void createJuly() {
        daysInJuly = new ArrayList<>();
        for (int i = 1; i <= JULY.getNumberOfDays(); i++) {
            Date date = new Date(JULY, i);
            daysInJuly.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInAugust for correct amount of days in month.
    public void createAugust() {
        daysInAugust = new ArrayList<>();
        for (int i = 1; i <= AUGUST.getNumberOfDays(); i++) {
            Date date = new Date(AUGUST, i);
            daysInAugust.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInSeptember for correct amount of days in month.
    public void createSeptember() {
        daysInSeptember = new ArrayList<>();
        for (int i = 1; i <= SEPTEMBER.getNumberOfDays(); i++) {
            Date date = new Date(SEPTEMBER, i);
            daysInSeptember.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInOctober for correct amount of days in month.
    public void createOctober() {
        daysInOctober = new ArrayList<>();
        for (int i = 1; i <= OCTOBER.getNumberOfDays(); i++) {
            Date date = new Date(OCTOBER, i);
            daysInOctober.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInNovember for correct amount of days in month.
    public void createNovember() {
        daysInNovember = new ArrayList<>();
        for (int i = 1; i <= NOVEMBER.getNumberOfDays(); i++) {
            Date date = new Date(NOVEMBER, i);
            daysInNovember.add(date);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a list of Dates in daysInDecember for correct amount of days in month.
    public void createDecember() {
        daysInDecember = new ArrayList<>();
        for (int i = 1; i <= DECEMBER.getNumberOfDays(); i++) {
            Date date = new Date(DECEMBER, i);
            daysInDecember.add(date);
        }
    }


    // EFFECTS: runs nCal application
    public CalendarApp() {
        createJanuary();
        createFebruary();
        createMarch();
        createApril();
        createMay();
        createJune();
        createJuly();
        createAugust();
        createSeptember();
        createOctober();
        createNovember();
        createDecember();
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
        string = string + ".";
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
        string = string + ".";
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
        string = string + ".";
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
            printJanuary();
        } else if (command.equals("f")) {
            printFebruary();
        } else if (command.equals("m")) {
            printMarch();
        } else if (command.equals("a")) {
            printApril();
        } else if (command.equals("ma")) {
            printMay();
        } else if (command.equals("je")) {
            printJune();
        } else if (command.equals("jl")) {
            printJuly();
        } else {
            processCommandContinued(command);
        }
    }

    // EFFECTS: processes user input, and prints chosen month
    public void processCommandContinued(String command) {
        if (command.equals("au")) {
            printAugust();
        } else if (command.equals("s")) {
            printSeptember();
        }  else if (command.equals("o")) {
            printOctober();
        } else if (command.equals("n")) {
            printNovember();
        } else if (command.equals("d")) {
            printDecember();
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
            Event event = new Event(name, time);
            l.get(day - 1).addEvent(event);
            System.out.println("Reminder has been added.");
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
            Reminder reminder = new Reminder(name, time);
            l.get(day - 1).addReminder(reminder);
            System.out.println("Reminder has been added.");
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
            Todo todo = new Todo(name, time);
            l.get(day - 1).addTodo(todo);
            System.out.println("Task has been added.");
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

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of January,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printJanuary() {
        System.out.println("-------------------January-------------------");
        for (int i = 0; i <= (daysInJanuary.size() - 1); i++) {
            System.out.println((((daysInJanuary.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInJanuary.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInJanuary.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInJanuary.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInJanuary.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInJanuary);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of February,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printFebruary() {
        System.out.println("-------------------February-------------------");
        for (int i = 0; i <= (daysInFebruary.size() - 1); i++) {
            System.out.println((((daysInFebruary.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInFebruary.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInFebruary.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInFebruary.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInFebruary.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInFebruary);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of March,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printMarch() {
        System.out.println("-------------------March-------------------");
        for (int i = 0; i <= (daysInMarch.size() - 1); i++) {
            System.out.println((((daysInMarch.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInMarch.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInMarch.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInMarch.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInMarch.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInMarch);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of April,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printApril() {
        System.out.println("-------------------April-------------------");
        for (int i = 0; i <= (daysInApril.size() - 1); i++) {
            System.out.println((((daysInApril.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInApril.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInApril.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInApril.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInApril.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInApril);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of May,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printMay() {
        System.out.println("-------------------May-------------------");
        for (int i = 0; i <= (daysInMay.size() - 1); i++) {
            System.out.println((((daysInMay.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInMay.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInMay.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInMay.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInMay.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInMay);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of June,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printJune() {
        System.out.println("-------------------June-------------------");
        for (int i = 0; i <= (daysInJune.size() - 1); i++) {
            System.out.println((((daysInJune.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInJune.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInJune.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInJune.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInJune.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInJune);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of July,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printJuly() {
        System.out.println("-------------------July-------------------");
        for (int i = 0; i <= (daysInJuly.size() - 1); i++) {
            System.out.println((((daysInJuly.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInJuly.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInJuly.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInJuly.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInJuly.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInJuly);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of August,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printAugust() {
        System.out.println("-------------------August-------------------");
        for (int i = 0; i <= (daysInAugust.size() - 1); i++) {
            System.out.println((((daysInAugust.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInAugust.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInAugust.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInAugust.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInAugust.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInAugust);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of September,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printSeptember() {
        System.out.println("-------------------September-------------------");
        for (int i = 0; i <= (daysInSeptember.size() - 1); i++) {
            System.out.println((((daysInSeptember.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInSeptember.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInSeptember.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInSeptember.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInSeptember.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInSeptember);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of October,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printOctober() {
        System.out.println("-------------------October-------------------");
        for (int i = 0; i <= (daysInOctober.size() - 1); i++) {
            System.out.println((((daysInOctober.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInOctober.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInOctober.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInOctober.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInOctober.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInOctober);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of November,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printNovember() {
        System.out.println("-------------------November-------------------");
        for (int i = 0; i <= (daysInNovember.size() - 1); i++) {
            System.out.println((((daysInNovember.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInNovember.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInNovember.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInNovember.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInNovember.get(i)));
        }
        displayMonthMenu();
        String command;
        command = input.next();
        processMonthCommand(command, daysInNovember);
    }

    // MODIFIES: this
    // EFFECTS: Prints out every date in the month of December,
    //          prints all events, reminds, and tasks for each date,
    //          then prompts users with options for month.
    public void printDecember() {
        System.out.println("-------------------December-------------------");
        for (int i = 0; i <= (daysInDecember.size() - 1); i++) {
            System.out.println((((daysInDecember.get(i)).getMonth()).getNameOfMonth()) + " "
                    + daysInDecember.get(i).getDay());
            System.out.println("\tEvents: " + returnEvent(daysInDecember.get(i)));
            System.out.println("\tReminders: " + returnReminder(daysInDecember.get(i)));
            System.out.println("\tTodos: " + returnTodo(daysInDecember.get(i)));
        }
        displayMonthMenu();
        String command = null;
        command = input.next();
        processMonthCommand(command, daysInDecember);
    }

}



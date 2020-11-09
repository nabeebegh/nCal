package ui;

import model.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
 ~RunCalendarApp.java~
  Class which runs nCal for end user.
*/

public class RunCalendarApp extends JFrame {

    // CONSTANTS
    private static final int MAIN_MENU_WIDTH = 300;
    private static final int MAIN_MENU_LENGTH = 180;

    private static final int VIEW_MONTHS_WIDTH = 210;
    private static final int VIEW_MONTHS_LENGTH = 415;

    private static final int MONTH_WIDTH = 600;
    private static final int MONTH_LENGTH = 505;

    // FIELDS
    private CalendarApp calendarApp;
    private List<Date> listOfDays;

    DefaultListModel<String> eventList;
    DefaultListModel<String> reminderList;
    DefaultListModel<String> todoList;

    private JFrame frame;

    private JList<String> events;
    private JList<String> reminders;
    private JList<String> todos;

    private JComboBox dates;

    private JPanel mainMenu;
    private JPanel viewMonths;
    private JPanel monthPanel;

    private JButton viewCalendar;
    private JButton saveCalendar;
    private JButton loadCalendar;
    private JButton quitApp;
    private JButton january;
    private JButton february;
    private JButton march;
    private JButton april;
    private JButton may;
    private JButton june;
    private JButton july;
    private JButton august;
    private JButton september;
    private JButton october;
    private JButton november;
    private JButton december;
    private JButton returnToMainMenu;
    private JButton addEvent;
    private JButton addReminder;
    private JButton addTodo;
    private JButton removeEvent;
    private JButton removeReminder;
    private JButton removeTodo;
    private JButton backButton;
    private JButton update;

    private JLabel mainMenuText;
    private JLabel viewMonthsText;
    private JLabel monthPanelText;
    private JLabel monthNameText;
    private JLabel eventText;
    private JLabel reminderText;
    private JLabel todoText;

    private JScrollPane eventScroll;
    private JScrollPane reminderScroll;
    private JScrollPane todoScroll;

    private String monthName;

    public RunCalendarApp() {
        calendarApp = new CalendarApp();
        mainMenu();
        listOfDatesMax();
        newFrame(mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH);
    }

    public void initializeMainMenuButtons() {
        viewCalendar = new JButton("View Calendar >>");
        saveCalendar = new JButton("Save Calendar");
        loadCalendar = new JButton("Load Calendar");
        quitApp = new JButton("Quit");
        mainMenuEvents();
    }

    public void mainMenuEvents() {
        viewCalendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewMonths();
                switchWindow(mainMenu, viewMonths, BorderLayout.SOUTH, VIEW_MONTHS_WIDTH, VIEW_MONTHS_LENGTH);
            }
        });
        saveCalendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuText.setText("Calendar has been saved.");
                saveCalendar();
            }
        });
        loadCalendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuText.setText("Previously saved calendar has been loaded.");
                loadCalendar();
            }
        });
        quitApp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void saveCalendar() {
        calendarApp.saveAllMonths();
    }

    public void loadCalendar() {
        calendarApp.loadAllMonths();
    }

    public void newFrame(JPanel panel, String layout, int w, int l) {
        frame = new JFrame();
        frame.add(panel, layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("nCal");
        frame.setSize(w, l);
        frame.setVisible(true);
    }

    public void closeFrame(JPanel panel) {
        frame.setVisible(false);
    }

    public void mainMenu() {
        initializeMainMenuButtons();
        mainMenu = new JPanel(new BorderLayout());
        mainMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainMenu.setLayout(new GridLayout(5, 1));
        mainMenuText = new JLabel("Welcome to nCal!");
        mainMenu.add(mainMenuText);
        mainMenuText.setHorizontalAlignment(JLabel.CENTER);
        mainMenuText.setVerticalAlignment(JLabel.CENTER);
        addButton(viewCalendar, mainMenu);
        addButton(saveCalendar, mainMenu);
        addButton(loadCalendar, mainMenu);
        addButton(quitApp, mainMenu);
    }

    public void initializeViewMonthsButtons() {
        january = new JButton("January");
        february = new JButton("February");
        march = new JButton("March");
        april = new JButton("April");
        may = new JButton("May");
        june = new JButton("June");
        july = new JButton("July");
        august = new JButton("August");
        september = new JButton("September");
        october = new JButton("October");
        november = new JButton("November");
        december = new JButton("December");
        returnToMainMenu = new JButton(" << Return to Main Menu");
    }

    public void viewMonths() {
        initializeViewMonthsButtons();
        viewMonths = new JPanel(new BorderLayout());
        viewMonths.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        viewMonths.setLayout(new GridLayout(14, 1));
        viewMonthsText = new JLabel("Select a month.");
        viewMonths.add(viewMonthsText);
        viewMonthsText.setHorizontalAlignment(JLabel.CENTER);
        viewMonthsText.setVerticalAlignment(JLabel.CENTER);
        addButtonsToViewMonthsPanel(viewMonths);
        addButton(returnToMainMenu, viewMonths);
    }

    public void switchWindow(JPanel oldPanel, JPanel newPanel, String str, int a, int b) {
        closeFrame(oldPanel);
        newFrame(newPanel, str, a, b);
    }

    public void addButtonsToViewMonthsPanel(JPanel panel) {
        addButton(january, panel);
        addButton(february, panel);
        addButton(march, panel);
        addButton(april, panel);
        addButton(may, panel);
        addButton(june, panel);
        addButton(july, panel);
        addButton(august, panel);
        addButton(september, panel);
        addButton(october, panel);
        addButton(november, panel);
        addButton(december, panel);
        viewMonthsEvents();
    }

    public void viewMonthsEvents() {
        returnToMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchWindow(viewMonths, mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH);
            }
        });
        january.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOfDatesMax();
                monthName = "January";
                listOfDays = calendarApp.getDaysInJanuary();
                viewMonthPanel(1, listOfDays, "January");
                switchWindow(viewMonths, monthPanel, BorderLayout.SOUTH, MONTH_WIDTH, MONTH_LENGTH);
            }
        });
        february.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOfDatesInFebruary();
                monthName = "February";
                listOfDays = calendarApp.getDaysInFebruary();
                viewMonthPanel(1, listOfDays, monthName);
                switchWindow(viewMonths, monthPanel, BorderLayout.SOUTH, MONTH_WIDTH, MONTH_LENGTH);
            }
        });
    }

    public void listOfDatesMax() {
        String[] listOfDates = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dates = new JComboBox(listOfDates);
    }

    public void listOfDates() {
        String[] listOfDatesMax = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        dates = new JComboBox(listOfDatesMax);
    }

    public void listOfDatesInFebruary() {
        String[] listOfDatesInFebruary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        dates = new JComboBox(listOfDatesInFebruary);
    }

    public DefaultListModel getEvents(int day, List<Date> l) {
        Date d = l.get(day - 1);
        eventList = new DefaultListModel();
        for (int i = 0; (i <= d.getEventList().size() - 1); i++) {
            String string = "(" + (i + 1) + ") " + ((d.getEventList().get(i).getEventName()) + " @ "
                    + (d.getEventList().get(i).getTime()));
            eventList.addElement(string);
        }
        return eventList;
    }

    public DefaultListModel getReminders(int day, List<Date> l) {
        Date d = l.get(day - 1);
        reminderList = new DefaultListModel();
        for (int i = 0; (i <= d.getReminderList().size() - 1); i++) {
            String string = "(" + (i + 1) + ") " + ((d.getReminderList().get(i).getReminderName()) + " @ "
                    + (d.getReminderList().get(i).getTime()));
            reminderList.addElement(string);
        }
        return reminderList;
    }

    public DefaultListModel getTodos(int day, List<Date> l) {
        Date d = l.get(day - 1);
        todoList = new DefaultListModel();
        for (int i = 0; (i <= d.getTodoList().size() - 1); i++) {
            String string = "(" + (i + 1) + ") " + ((d.getTodoList().get(i).getTodoName()) + " @ "
                    + (d.getTodoList().get(i).getTime()));
            todoList.addElement(string);
        }
        return todoList;
    }

    public void updateEntries(int day, List<Date> l) {
        events = new JList(getEvents(day, l));
        reminders = new JList(getReminders(day, l));
        todos = new JList(getTodos(day, l));
    }

    public void initializeViewMonthLabels(String str) {
        monthNameText = new JLabel(str);
        monthPanelText = new JLabel("Select a day:");
        eventText = new JLabel("Events");
        reminderText = new JLabel("Reminder");
        todoText = new JLabel("Todo");
    }

    public void alignLabels() {
        monthPanelText.setHorizontalAlignment(JLabel.CENTER);
        monthPanelText.setVerticalAlignment(JLabel.CENTER);
        monthNameText.setHorizontalAlignment(JLabel.CENTER);
        monthNameText.setVerticalAlignment(JLabel.CENTER);
        eventText.setHorizontalAlignment(JLabel.CENTER);
        eventText.setVerticalAlignment(JLabel.CENTER);
        reminderText.setHorizontalAlignment(JLabel.CENTER);
        reminderText.setVerticalAlignment(JLabel.CENTER);
        todoText.setHorizontalAlignment(JLabel.CENTER);
        todoText.setVerticalAlignment(JLabel.CENTER);
    }

    public void viewMonthPanel(int day, List<Date> l, String str) {
        initializeMonthPanelButtons();
        monthPanel = new JPanel(new BorderLayout());
        monthPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        monthPanel.setLayout(new GridLayout(6, 3));
        initializeViewMonthLabels(str);
        updateEntries(day, l);
        monthPanel.add(monthNameText);
        monthPanel.add(monthPanelText);
        monthPanel.add(dates);
        monthPanel.add(eventText);
        monthPanel.add(reminderText);
        monthPanel.add(todoText);
        monthPanel.add(events);
        monthPanel.add(reminders);
        monthPanel.add(todos);
        alignLabels();
        addButtonsToMonthPanel(monthPanel);
    }

    public void initializeMonthPanelButtons() {
        addEvent = new JButton("Add Event");
        addReminder = new JButton("Add Reminder");
        addTodo = new JButton("Add Todo");
        removeEvent = new JButton("Remove Event");
        removeReminder = new JButton("Remove Reminder");
        removeTodo = new JButton("Remove Todo");
        backButton = new JButton("<< Month Selection");
        update = new JButton("Update to selected date");
    }

    public void addButtonsToMonthPanel(JPanel panel) {
        addButton(addEvent, panel);
        addButton(addReminder, panel);
        addButton(addTodo, panel);
        addButton(removeEvent, panel);
        addButton(removeReminder, panel);
        addButton(removeTodo, panel);
        addButton(update, panel);
        addButton(backButton, panel);
        monthPanelEvents();
    }

    public void monthPanelEvents() {
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int day = dates.getSelectedIndex() + 1;
                viewMonthPanel(day, listOfDays, monthName);
                switchWindow(monthPanel, monthPanel, BorderLayout.SOUTH, MONTH_WIDTH, MONTH_LENGTH);
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchWindow(monthPanel, viewMonths, BorderLayout.SOUTH, VIEW_MONTHS_WIDTH, VIEW_MONTHS_LENGTH);
            }
        });
    }

    public void addButton(JButton button, JPanel panel) {
        panel.add(button);
    }

    public static void main(String[] args) {
        new RunCalendarApp();
    }

}

package ui;

import model.*;
import model.Event;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/*
 ~RunCalendarApp.java~
  Class which runs nCal for end user.
*/

public class RunCalendarApp {

    // CONSTANTS
    private static final int MAIN_MENU_WIDTH = 300;
    private static final int MAIN_MENU_LENGTH = 180;

    private static final int VIEW_MONTHS_WIDTH = 210;
    private static final int VIEW_MONTHS_LENGTH = 415;

    private static final int MONTH_WIDTH = 610;
    private static final int MONTH_LENGTH = 640;

    private static final int ADD_WIDTH = 600;
    private static final int ADD_LENGTH = 145;

    // FIELDS
    private CalendarApp calendarApp;
    private String monthName;
    private String action;

    private JFrame frame;

    private JList<String> events;
    private JList<String> reminders;
    private JList<String> todos;

    private JComboBox dates;

    private JPanel mainMenu;
    private JPanel viewMonths;
    private JPanel monthPanel;
    private JPanel addPanel;

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
    private JButton enter;
    private JButton returnToCalendar;
    private JButton saveCalendarInViewMonth;
    private JButton exitCalendarInViewMonth;

    private JLabel mainMenuText;
    private JLabel viewMonthsText;
    private JLabel monthPanelText;
    private JLabel monthNameText;
    private JLabel eventText;
    private JLabel reminderText;
    private JLabel todoText;
    private JLabel name;
    private JLabel time;

    private JTextField nameField;
    private JTextField timeField;

    private DefaultListModel<String> eventList;
    private DefaultListModel<String> reminderList;
    private DefaultListModel<String> todoList;

    private Border border;

    private ImageIcon img;

    // MODIFIES: this
    // EFFECTS: Initializes CalendarApp and the mainMenu JPanel.
    //          Displays JFrame and plays appOpen sound
    public RunCalendarApp() {
        calendarApp = new CalendarApp();
        mainMenu();
        img = new ImageIcon("./data/icon/icon.png");
        newFrame(mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH);
        playSound("appOpen");
    }

    // EFFECTS: Plays specifies.wav file.
    //          Options for sounds are: "appOpen", "appClose", "calendarSaved", "calendarLoaded", and "error".
    public void playSound(String soundName) {
        InputStream sound;
        try {
            sound = new FileInputStream(new File("./data/sounds/" + soundName + ".wav"));
            AudioStream audio = new AudioStream(sound);
            AudioPlayer.player.start(audio);
        } catch (IOException e) {
            System.out.println("Error with playSound(" + soundName + ")");
        }
    }

    // MODIFIES: this
    // EFFECTS: Instantiates main menu JButtons. Call is then made to event listener method for these buttons.
    public void initializeMainMenuButtons() {
        viewCalendar = new JButton("View Calendar >>");
        saveCalendar = new JButton("Save Calendar");
        loadCalendar = new JButton("Load Calendar");
        quitApp = new JButton("Quit");
        mainMenuEvents();
    }

    // EFFECTS: Event listener for when main menu buttons are pressed.
    //          When button is pressed, performs specified actions.
    public void mainMenuEvents() {
        viewCalendar.addActionListener(e -> {
            viewMonths();
            switchWindow(viewMonths, BorderLayout.SOUTH, VIEW_MONTHS_WIDTH, VIEW_MONTHS_LENGTH);
        });
        saveCalendar.addActionListener(e -> saveCalendar());
        loadCalendar.addActionListener(e -> loadCalendar());
        quitApp.addActionListener(e -> {
            playSound("appClose");
            delay(1550);
            System.exit(0);
        });
    }

    // EFFECTS: causes delay where app becomes inactive for i milliseconds.
    public void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception ev) {
            System.out.println("Error with delay()");
        }
    }

    // EFFECTS: saves calendar and plays calendarSaved sound.
    public void saveCalendar() {
        calendarApp.saveAllMonths();
        mainMenuText.setText("Calendar has been saved.");
        playSound("calendarSaved");
    }

    // EFFECTS: loads calendar and plays calendarLoaded sound.
    public void loadCalendar() {
        calendarApp.loadAllMonths();
        mainMenuText.setText("Previously saved calendar has been loaded.");
        playSound("calendarLoaded");
    }

    // MODIFIES: this
    // EFFECTS: creates new frame with specified JPanel, layout, and dimensions.
    public void newFrame(JPanel panel, String layout, int w, int l) {
        frame = new JFrame();
        frame.add(panel, layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("nCal");
        frame.setIconImage(img.getImage());
        frame.setSize(w, l);
        frame.setVisible(true);
    }

    // EFFECTS: Sets visibility to current open frame to false, making it invisible to the user.
    public void closeFrame() {
        frame.setVisible(false);
    }

    // MODIFIES: this
    // EFFECTS: instantiates mainMenu JPanel, set panel settings, then adds labels and button.
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

    // MODIFIES: this
    // EFFECTS: instantiates buttons for the viewMonths JPanel.
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

    // MODIFIES: this
    // EFFECTS: instantiates viewMonths JPanel, set panel settings, then adds labels and button.
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

    // EFFECTS: closes current frame, and then opens new frame with specified JPanel, layout and dimensions.
    public void switchWindow(JPanel newPanel, String str, int a, int b) {
        closeFrame();
        newFrame(newPanel, str, a, b);
    }

    // EFFECTS: Adds month JButtons to specified panel, then makes call to event listener for viewMonths panel.
    //          Specified panel is intended to only be the viewMonths panel();
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

    // MODIFIES: this
    // EFFECTS: allocates correct number of days to which ever month has been selected in monthPanel.
    //          then buildCalendar is called for a month and its list of days.
    public void viewCalendar(JButton button, String nameOfMonth, List<Date> l) {
        button.addActionListener(e -> {
            if (nameOfMonth.equals("February")) {
                listOfDatesInFebruary();
            } else if ((nameOfMonth.equals("January") || ((nameOfMonth.equals("March"))
                    || ((nameOfMonth.equals("May")) || (nameOfMonth.equals("July") || (nameOfMonth.equals("August")
                    || (nameOfMonth.equals("October") || (nameOfMonth.equals("December"))))))))) {
                listOfDatesMax();
            } else {
                listOfDates();
            }
            buildCalendar(nameOfMonth, l);
        });
    }

    // EFFECTS: Event listener for when viewMonths buttons are pressed.
    //          When button is pressed, performs specified actions.
    //          viewCalendar is called if the button pressed is a month.
    public void viewMonthsEvents() {
        returnToMainMenu.addActionListener(e -> switchWindow(
                mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH));
        viewCalendar(january, "January", calendarApp.daysInJanuary);
        viewCalendar(february, "February", calendarApp.daysInFebruary);
        viewCalendar(march, "March", calendarApp.daysInMarch);
        viewCalendar(april, "April", calendarApp.daysInApril);
        viewCalendar(may, "May", calendarApp.daysInMay);
        viewCalendar(june, "June", calendarApp.daysInJune);
        viewCalendar(july, "July", calendarApp.daysInJuly);
        viewCalendar(august,"August", calendarApp.daysInAugust);
        viewCalendar(september, "September", calendarApp.daysInSeptember);
        viewCalendar(october, "October", calendarApp.daysInOctober);
        viewCalendar(november, "November", calendarApp.daysInNovember);
        viewCalendar(december,"December", calendarApp.daysInDecember);
    }

    // MODIFIES: this
    // EFFECTS: creates monthPanel with specified month and its list of days.
    public void buildCalendar(String str, List<Date> l) {
        monthName = str;
        viewMonthPanel(1, l, monthName);
        switchWindow(monthPanel, BorderLayout.NORTH, MONTH_WIDTH, MONTH_LENGTH);
    }

    // MODIFIES: this
    // EFFECTS: constructs JComboBox for months with 31 days.
    public void listOfDatesMax() {
        String[] listOfDates = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dates = new JComboBox(listOfDates);
    }

    // MODIFIES: this
    // EFFECTS: constructs JComboBox for months with 30 days.
    public void listOfDates() {
        String[] listOfDatesMax = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        dates = new JComboBox(listOfDatesMax);
    }

    // MODIFIES: this
    // EFFECTS: constructs JComboBox for February.
    public void listOfDatesInFebruary() {
        String[] listOfDatesInFebruary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        dates = new JComboBox(listOfDatesInFebruary);
    }

    // MODIFIES: this
    // EFFECTS: instantiates eventList as a DefaultListModel, adds events to eventList  for specified day
    //          and returns the DefaultListModel which will later be used in a JList.
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

    // MODIFIES: this
    // EFFECTS: instantiates reminderList as a DefaultListModel, adds reminders to reminderList for specified day
    //          and returns the DefaultListModel which will later be used in a JList.
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

    // MODIFIES: this
    // EFFECTS: instantiates todoList as a DefaultListModel, adds tasks to toddList for specified day
    //          and returns the DefaultListModel which will later be used in a JList.
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

    // MODIFIES: this
    // EFFECTS: instantiates JLists for events, reminders and todos with DefaultListModels
    public void updateEntries(int day, List<Date> l) {
        events = new JList(getEvents(day, l));
        reminders = new JList(getReminders(day, l));
        todos = new JList(getTodos(day, l));
    }

    // EFFECTS: adds scrollbar to specified JList and adds its to specified panel.
    public void addScrollBarToList(JList list, JPanel panel) {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollbar = new JScrollPane();
        listScrollbar.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel.add(listScrollbar);
    }

    // MODIFIES: this
    // EFFECTS: instantiates viewMonth panel labels, and assigns attributes to the labels.
    //          attributes include adding a border to label or underlining the label.
    public void initializeViewMonthLabels(String str) {
        monthNameText = new JLabel(str);
        border = BorderFactory.createLineBorder(Color.DARK_GRAY, 15);
        monthNameText.setBorder(border);
        monthPanelText = new JLabel("Select a day:");
        eventText = new JLabel("Events");
        Font font = eventText.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        eventText.setFont(font.deriveFont(attributes));
        reminderText = new JLabel("Reminder");
        font = reminderText.getFont();
        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        reminderText.setFont(font.deriveFont(attributes));
        todoText = new JLabel("Todo");
        font = todoText.getFont();
        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        todoText.setFont(font.deriveFont(attributes));
    }

    // EFFECTS: Aligns all labels to the center of their cells.
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

    // MODIFIES: this
    // EFFECTS: instantiates monthPanel, and constructs panel for specified month
    public void viewMonthPanel(int day, List<Date> l, String str) {
        initializeMonthPanelButtons();
        monthPanel = new JPanel(new BorderLayout());
        monthPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        monthPanel.setLayout(new GridLayout(6, 3, 5, 5));
        initializeViewMonthLabels(str);
        updateEntries(day, l);
        monthPanel.add(monthNameText);
        monthPanel.add(dates);
        addButton(update, monthPanel);
        monthPanel.add(eventText);
        monthPanel.add(reminderText);
        monthPanel.add(todoText);
        addScrollBarToList(events, monthPanel);
        addScrollBarToList(reminders, monthPanel);
        addScrollBarToList(todos, monthPanel);
        alignLabels();
        addButtonsToMonthPanel(monthPanel);
        monthPanelEvents(l);
        monthPanel.setPreferredSize(new Dimension(100,600));
        addToCalendarPanel(l);
    }

    // MODIFIES: this
    // EFFECTS: instantiates JButtons for use in monthPanel
    public void initializeMonthPanelButtons() {
        addEvent = new JButton("Add Event");
        addReminder = new JButton("Add Reminder");
        addTodo = new JButton("Add Todo");
        removeEvent = new JButton("Remove Event");
        removeReminder = new JButton("Remove Reminder");
        removeTodo = new JButton("Mark Todo Completed");
        backButton = new JButton("<< Month Selection");
        update = new JButton("Show selected date");
        saveCalendarInViewMonth = new JButton("Save");
        exitCalendarInViewMonth = new JButton("Quit");
    }

    // EFFECTS: adds monthPanel buttons to specified panel.
    //          intended to be only used with monthPanel.
    public void addButtonsToMonthPanel(JPanel panel) {
        addButton(addEvent, panel);
        addButton(addReminder, panel);
        addButton(addTodo, panel);
        addButton(removeEvent, panel);
        addButton(removeReminder, panel);
        addButton(removeTodo, panel);
        addButton(backButton, panel);
        addButton(saveCalendarInViewMonth, panel);
        addButton(exitCalendarInViewMonth, panel);
    }

    // EFFECTS: event listener for monthPanel, performs specified action for the button that was pressed.
    public void monthPanelEvents(List<Date> l) {
        update.addActionListener(e -> {
            int day = dates.getSelectedIndex() + 1;
            viewMonthPanel(day, l, monthName);
            switchWindow(monthPanel, BorderLayout.NORTH, MONTH_WIDTH, MONTH_LENGTH);
        });
        backButton.addActionListener(
                e -> switchWindow(viewMonths, BorderLayout.SOUTH, VIEW_MONTHS_WIDTH, VIEW_MONTHS_LENGTH));
        addToCalendarEvent(addEvent, "e");
        addToCalendarEvent(addReminder, "r");
        addToCalendarEvent(addTodo, "t");
        removeFromCalendarEvent(removeEvent, "e", l);
        removeFromCalendarEvent(removeReminder, "r", l);
        removeFromCalendarEvent(removeTodo, "t", l);
        monthPanelEventsTwo();
    }

    // EFFECTS: monthPanelEvents() extended, handles the save and quit buttons.
    public void monthPanelEventsTwo() {
        saveCalendarInViewMonth.addActionListener(e -> saveCalendar());
        exitCalendarInViewMonth.addActionListener(e -> {
            playSound("appClose");
            delay(1550);
            System.exit(0);
        });
    }

    // EFFECTS: event listener for specified buttons that remove entries from eventList, reminderList, or todoList.
    public void removeFromCalendarEvent(JButton button, String str, List<Date> l) {
        button.addActionListener(e -> removeFromCalendar(str, l));
    }

    // MODIFIES: this
    // EFFECTS: removes selected entry from eventList, reminderList, or todoList.
    //          if nothing is selected, plays error sound.
    public void removeFromCalendar(String str, List<Date> l) {
        action = str;
        try {
            if (action.equals("e")) {
                l.get(dates.getSelectedIndex()).removeEvent(l.get(dates.getSelectedIndex()).getEventList().get(
                        events.getSelectedIndex()));
            } else if (action.equals("r")) {
                l.get(dates.getSelectedIndex()).removeReminder(l.get(dates.getSelectedIndex()).getReminderList().get(
                        reminders.getSelectedIndex()));
            } else if (action.equals("t")) {
                l.get(dates.getSelectedIndex()).removeTodo(l.get(dates.getSelectedIndex()).getTodoList().get(
                        todos.getSelectedIndex()));
            }
            viewMonthPanel(dates.getSelectedIndex() + 1, l, monthName);
            switchWindow(monthPanel, BorderLayout.NORTH, MONTH_WIDTH, MONTH_LENGTH);
        } catch (Exception e) {
            playSound("error");
        }
    }

    // EFFECTS: event listener for specified buttons that add entries to eventList, reminderList, or todoList.
    public void addToCalendarEvent(JButton button, String str) {
        button.addActionListener(e -> {
            action = str;
            switchWindow(addPanel, BorderLayout.SOUTH, ADD_WIDTH, ADD_LENGTH);
        });
    }

    // MODIFIES: this
    // EFFECTS: instantiates addPanel, the panel used to enter name and time of a calendar entry.
    public void addToCalendarPanel(List<Date> l) {
        addPanel = new JPanel(new GridLayout(3,2,5,5));
        addPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initializeAddToCalendarPanelLabels();
        initializeAddToCalendarTextFields();
        initializeAddToCalendarPanelButtons();
        addPanel.add(name);
        addPanel.add(nameField);
        addPanel.add(time);
        addPanel.add(timeField);
        addPanel.add(enter);
        addPanel.add(returnToCalendar);
        addToCalendarPanelEvents(l);
    }

    // EFFECTS: event listener for addPanel buttons, performs specified action when button is pressed.
    public void addToCalendarPanelEvents(List<Date> l) {
        returnToCalendar.addActionListener(
                e -> switchWindow(monthPanel, BorderLayout.NORTH, MONTH_WIDTH, MONTH_LENGTH));
        enter.addActionListener(e -> {
            if (addToCalendar(l)) {
                playSound("calendarLoaded");
                switchWindow(monthPanel, BorderLayout.NORTH, MONTH_WIDTH, MONTH_LENGTH);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: adds entry from addPanel to specified list. Plays error sound if user made an input mistake.
    public boolean addToCalendar(List<Date> l) {
        if ((!(nameField.getText().equals("") && timeField.getText().equals(""))) && checkTimeFormat(timeField.getText()
        )) {
            if (action.equals("e")) {
                int time = Integer.parseInt(timeField.getText());
                Event e = new Event(nameField.getText(), time);
                l.get(dates.getSelectedIndex()).addEvent(e);
            } else if (action.equals("r")) {
                int time = Integer.parseInt(timeField.getText());
                Reminder r = new Reminder(nameField.getText(), time);
                l.get(dates.getSelectedIndex()).addReminder(r);
            } else if (action.equals("t")) {
                int time = Integer.parseInt(timeField.getText());
                Todo t = new Todo(nameField.getText(), time);
                l.get(dates.getSelectedIndex()).addTodo(t);
            }
            viewMonthPanel(dates.getSelectedIndex() + 1, l, monthName);
            return true;
        } else {
            timeField.setText("ERROR");
            playSound("error");
            return false;
        }
    }

    // EFFECTS: returns true if user entered time of entry correctly, false otherwise.
    public boolean checkTimeFormat(String str) {
        boolean b;
        int timeLength = str.length();
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        int time = Integer.parseInt(str);
        b = (timeLength == 4) && (time <= 2359);
        return b;
    }

    // MODIFIES: this
    // EFFECTS: instantiates JTextfields for addPanel. Also adds mouseListener so that field is cleared when clicked.
    public void initializeAddToCalendarTextFields() {
        nameField = new JTextField();
        timeField = new JTextField();
        timeField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                timeField.setText("");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: instantiates JLables for addPanel.
    public void initializeAddToCalendarPanelLabels() {
        name = new JLabel("Enter Name of Entry:");
        time = new JLabel("Enter Time in 24-Hour Format (0000-2359):");
    }

    // MODIFIES: this
    // EFFECTS: instantiates JButtons for addPanel.
    public void initializeAddToCalendarPanelButtons() {
        enter = new JButton("Add to Calendar");
        returnToCalendar = new JButton("Return to Calendar");
    }

    // EFFECTS: adds specified button to specified panel.
    public void addButton(JButton button, JPanel panel) {
        panel.add(button);
    }

    // EFFECTS: runs CalendarApp GUI.
    public static void main(String[] args) {
        new RunCalendarApp();
    }

}

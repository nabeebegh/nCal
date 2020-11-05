package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    // FIELDS
    private CalendarApp calendarApp;

    private JFrame frame;

    private JPanel mainMenu;
    private JPanel viewMonths;

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

    private JLabel mainMenuText;
    private JLabel viewMonthsText;

    public void initializeMainMenuButtons() {
        viewCalendar = new JButton("View Calendar");
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

    public RunCalendarApp() {
        calendarApp = new CalendarApp();
        mainMenu();
        newFrame(mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH);
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
        returnToMainMenu = new JButton("Return to Main Menu");
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
    }

    public void addButton(JButton button, JPanel panel) {
        panel.add(button);
    }

    public static void main(String[] args) {
        new RunCalendarApp();
    }

}

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
    private static final int MAIN_MENU_WIDTH = 250;
    private static final int MAIN_MENU_LENGTH = 180;

    // FIELDS
    private JFrame frame;
    private JPanel mainMenu;
    private JButton viewCalendar;
    private JButton saveCalendar;
    private JButton loadCalendar;
    private JButton quitApp;
    private JLabel mainMenuText;

    public void initializeMainMenuButtons() {
        viewCalendar = new JButton("View Calendar");
        saveCalendar = new JButton("Save Calendar");
        loadCalendar = new JButton("Load Calendar");
        quitApp = new JButton("Quit");
        mainMenuEvents();
    }

    public void mainMenuEvents() {
        viewCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        saveCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuText.setText("Calendar has been saved.");
            }
        });
        loadCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuText.setText("Previously saved calendar has been loaded.");
            }
        });
        quitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public RunCalendarApp() {
        initializeMainMenuButtons();
        mainMenu();
        newFrame(mainMenu, BorderLayout.SOUTH, MAIN_MENU_WIDTH, MAIN_MENU_LENGTH);
    }

    public void newFrame(JPanel panel, String layout, int w, int l) {
        frame = new JFrame();
        frame.add(panel, layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("nCal");
        frame.setSize(w, l);
        frame.setVisible(true);
    }

    public void hidePanel(JPanel panel) {
        panel.setVisible(false);
    }

    public void showPanel(JPanel panel) {
        panel.setVisible(true);
    }

    public void mainMenu() {
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

    public void addButton(JButton button, JPanel panel) {
        panel.add(button);
    }

    public static void main(String[] args) {
        new RunCalendarApp();
        new CalendarApp();
    }

}

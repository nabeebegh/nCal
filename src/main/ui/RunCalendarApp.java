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
    private static final int MAIN_MENU_WIDTH = 450;
    private static final int MAIN_MENU_LENGTH = 113;

    // FIELDS
    private JFrame frame;
    private JPanel mainMenu;
    private JButton viewCalendar;
    private JButton quitApp;

    public void mainMenuButtons() {
        viewCalendar = new JButton("View Calendar");
        quitApp = new JButton("Quit");
        quitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public RunCalendarApp() {
        mainMenuButtons();
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

    public void changeFrame(JPanel panel) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("nCal");
        frame.setVisible(false);
    }

    public void mainMenu() {
        mainMenu = new JPanel(new BorderLayout());
        mainMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainMenu.setLayout(new GridLayout(2, 1));
        addButton(viewCalendar, mainMenu);
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

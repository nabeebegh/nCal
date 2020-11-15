package persistence;

import model.*;
import org.json.JSONObject;
import java.io.*;

/*
 ~SaveCalendar.java~
  Represents a writer that writes JSON representation of Date to a save file

  Citation:
  Contents of this class were copied from JsonWriter class in JsonSerializationDemo
  provided by CPSC 210 course at UBC. Permission was given to model this writer
  after said class.
*/

public class SaveCalendar {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public SaveCalendar(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(Date d) {
        JSONObject json = d.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

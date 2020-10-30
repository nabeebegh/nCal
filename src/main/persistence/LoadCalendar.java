package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.*;

/*
 ~LoadCalendar.java~
  Represents a reader that reads JSON representation of Date stored in save file

  Citation:
  Contents of this class were modeled based on the JsonReader class in
  JsonSerializationDemo provided by CPSC 210 course at UBC. Permission was given
  to model this reader after said class.
*/

public class LoadCalendar {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public LoadCalendar(String source) {
        this.source = source;
    }

    // EFFECTS: if error occurs in attempt to read data from file,
    //          throw IOException
    //          otherwise, reads Date from file and returns it;
    public Date read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDate(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Date object for JSON object and returns it
    private Date parseDate(JSONObject jsonObject) {
        JSONObject monthJson = jsonObject.getJSONObject("month");
        String name = monthJson.getString("month");
        int day = jsonObject.getInt("day");
        Month month = new Month(name);
        Date d = new Date(month, day);
        addEventList(d, jsonObject);
        addReminderList(d, jsonObject);
        addTodoList(d, jsonObject);
        return d;
    }

    // MODIFIES: d
    // EFFECTS: parses eventList from JSON object and adds them to Date object
    private void addEventList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("events");
        for (Object json : jsonArray) {
            JSONObject nextEvent = (JSONObject) json;
            addEvent(d, nextEvent);
        }
    }

    // MODIFIES: d
    // EFFECTS: parses reminderList from JSON object and adds them to Date object
    private void addReminderList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("reminders");
        for (Object json : jsonArray) {
            JSONObject nextReminder = (JSONObject) json;
            addReminder(d, nextReminder);
        }
    }

    // MODIFIES: d
    // EFFECTS: parses todoList from JSON object and adds them to Date object
    private void addTodoList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("todos");
        for (Object json : jsonArray) {
            JSONObject nextTodo = (JSONObject) json;
            addTodo(d, nextTodo);
        }
    }

    // MODIFIES: d
    // EFFECTS: parses event objects in eventList and adds them to Date object
    private void addEvent(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Event e = new Event(name, time);
        d.addEvent(e);
    }

    // MODIFIES: d
    // EFFECTS: parses reminder objects in reminderList and adds them to Date object
    private void addReminder(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Reminder r = new Reminder(name, time);
        d.addReminder(r);
    }

    // MODIFIES: d
    // EFFECTS: parses To-do objects in todoList and adds them to Date object
    private void addTodo(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Todo t = new Todo(name, time);
        d.addTodo(t);
    }





}

package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.*;

public class LoadCalendar {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public LoadCalendar(String source) {
        this.source = source;
    }


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

    private void addEventList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("events");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addEvent(d, nextThingy);
        }
    }

    private void addReminderList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("reminders");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addReminder(d, nextThingy);
        }
    }

    private void addTodoList(Date d, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("todos");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addTodo(d, nextThingy);
        }
    }

    private void addEvent(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Event e = new Event(name, time);
        d.addEvent(e);
    }

    private void addReminder(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Reminder r = new Reminder(name, time);
        d.addReminder(r);
    }

    private void addTodo(Date d, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        Todo t = new Todo(name, time);
        d.addTodo(t);
    }





}

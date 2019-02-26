package main;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSONReader {

    public static HashMap<String, Colour> getSubjects() {

        JSONParser parser = new JSONParser();
        HashMap<String, Colour> results = new HashMap<>();

        Object obj;

        try {
            obj = parser.parse(new FileReader("timetable.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray JSONsubjects = (JSONArray) jsonObject.get("subjects");
            for (Object sub: JSONsubjects) {
                JSONObject jsonSub = (JSONObject) sub;
                Colour colour;
                try {
                    colour = Colour.valueOf((String) jsonSub.get("colour"));
                } catch (IllegalArgumentException e) {
                    colour = Colour.BLACK;
                }
                String name = (String) jsonSub.get("name");
                results.put(name, colour);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static List<TimeRow> getTimeRow() {

        List<TimeRow> results = new ArrayList<>();

        JSONParser parser = new JSONParser();

        Object obj;

        try {
            obj = parser.parse(new FileReader("timetable.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray hoursRow = (JSONArray) jsonObject.get("rows");

            for (Object row: hoursRow) {

                JSONObject jsonRow = (JSONObject) row;
                String hour = (String) jsonRow.get("hour");
                String mondaySubj = (String) jsonRow.get("mondaySubj");
                String tuesdaySubj = (String) jsonRow.get("tuesdaySubj");
                String wednesdaySubj  = (String) jsonRow.get("wednesdaySubj");
                String thursdaySubj = (String) jsonRow.get("thursdaySubj");
                String fridaySubj = (String) jsonRow.get("fridaySubj");

                results.add(new TimeRow(hour, mondaySubj, tuesdaySubj, wednesdaySubj, thursdaySubj, fridaySubj));

            }

        } catch (IOException | ParseException e) {
                e.printStackTrace();
        }

        return results;
    }

}

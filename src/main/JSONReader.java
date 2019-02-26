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

    /* The provided file "timetable.json" is an example of a possible time table.
       First, a list of all the subjects and a corresponding colour is chosen.
       Then, the time table is provided: the "name" of the subject is an acronym.
       Another approach would be to specify the various hour by day, so do something like
       "monday": [ 8.30 : "subj_name"
                    ... ]

       However, the row approach is suitable for a Table in JavaFX.

     */


    /* This method returns an HashMap with the name of the subject and its colour
       It's used to quicly set the text colour in the output table
     */
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
                    // If I can't read a good value, set it to black
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

    /* This method returns the rows that will be printed in the table, in ShowTable
       A row is composed by the starting hour, subject on monday in that hour, subject on tuesday in that hour etc.
       One clever approach would be to use an ArrayList, but considering that, usually, a five days week is used
       (six days at maximum) I chose to explicitly write the variables.
     */

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

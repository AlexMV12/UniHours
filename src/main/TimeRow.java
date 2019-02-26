package main;

public class TimeRow {

    /*
       A row is composed by the starting hour, subject on monday in that hour, subject on tuesday in that hour etc.
       One clever approach would be to use an ArrayList, but considering that, usually, a five days week is used
       (six days at maximum) I chose to explicitly write the variables.
     */

    private String hour;
    private String mondaySubj;
    private String tuesdaySubj;
    private String wednesdaySubj;
    private String thursdaySubj;
    private String fridaySubj;

    public TimeRow(String hour, String mondaySubj, String tuesdaySubj, String wednesdaySubj, String thursdaySubj, String fridaySubj) {
        this.hour = hour;
        this.mondaySubj = mondaySubj;
        this.tuesdaySubj = tuesdaySubj;
        this.wednesdaySubj = wednesdaySubj;
        this.thursdaySubj = thursdaySubj;
        this.fridaySubj = fridaySubj;
    }

    public String getHour() {
        return hour;
    }

    public String getMondaySubj() {
        return mondaySubj;
    }

    public String getTuesdaySubj() {
        return tuesdaySubj;
    }

    public String getWednesdaySubj() {
        return wednesdaySubj;
    }

    public String getThursdaySubj() {
        return thursdaySubj;
    }

    public String getFridaySubj() {
        return fridaySubj;
    }
}

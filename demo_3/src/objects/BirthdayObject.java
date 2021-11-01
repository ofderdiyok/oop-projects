package objects;

import abstractclasses.SpecialDayAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayObject extends SpecialDayAbstract {
    private int birthDayID;
    private String description;

    public BirthdayObject(int userID, Date date, SimpleDateFormat dateWithoutHour, int birthDayID, String description) {
        super(userID, date, dateWithoutHour);
        this.birthDayID = birthDayID;
        this.description = description;
    }

    public int getBirthDayID() {
        return birthDayID;
    }

    public void setBirthDayID(int birthDayID) {
        this.birthDayID = birthDayID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

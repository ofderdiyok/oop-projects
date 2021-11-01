package objects;

import abstractclasses.SpecialDayAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnniversaryObject extends SpecialDayAbstract {
    private int anniversaryID;
    private String description;

    public AnniversaryObject(int userID, Date date, SimpleDateFormat dateWithoutHour, int anniversaryID, String description) {
        super(userID, date, dateWithoutHour);
        this.anniversaryID = anniversaryID;
        this.description = description;
    }

    public int getAnniversaryID() {
        return anniversaryID;
    }

    public void setAnniversaryID(int anniversaryID) {
        this.anniversaryID = anniversaryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

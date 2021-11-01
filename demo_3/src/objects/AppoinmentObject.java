package objects;

import abstractclasses.EngagementAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppoinmentObject extends EngagementAbstract {
    private int appoinmentID;

    public AppoinmentObject(Date date, SimpleDateFormat dateWithHour, int duration, String[] userIDs, int appoinmentID) {
        super(date, dateWithHour, duration, userIDs);
        this.appoinmentID = appoinmentID;
    }

    public int getAppoinmentID() {
        return appoinmentID;
    }

    public void setAppoinmentID(int appoinmentID) {
        this.appoinmentID = appoinmentID;
    }
}

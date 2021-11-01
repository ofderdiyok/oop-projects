package abstractclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class EventAbstract {
    Date date = new Date();
    private int quota;
    private SimpleDateFormat dateWithHour;
    private int eventID;
    private String eventName;

    public EventAbstract(Date date, int quota, SimpleDateFormat dateWithHour, int eventID, String eventName) {
        this.date = date;
        this.quota = quota;
        this.dateWithHour = dateWithHour;
        this.eventID = eventID;
        this.eventName = eventName;
    }

    public String getDateWithHour() {
        return dateWithHour.format(date);
    }

    public void setDateWithHour(SimpleDateFormat dateWithHour) {
        this.dateWithHour = dateWithHour;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}

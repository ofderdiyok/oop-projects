package abstractclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class EngagementAbstract {
    Date date = new Date();
    private SimpleDateFormat dateWithHour;
    private int duration;
    private String[] userIDs;

    public EngagementAbstract(Date date, SimpleDateFormat dateWithHour, int duration, String[] userIDs) {
        this.date = date;
        this.dateWithHour = dateWithHour;
        this.duration = duration;
        this.userIDs = userIDs;
    }

    public String getDateWithHour() {
        return dateWithHour.format(date);
    }

    public void setDateWithHour(SimpleDateFormat dateWithHour) {
        this.dateWithHour = dateWithHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(String[] userIDs) {
        this.userIDs = userIDs;
    }
}

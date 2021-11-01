package objects;

import abstractclasses.EventAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SportObject extends EventAbstract {
    private String type = "SPORT";
    private int duration = 240;

    public SportObject(Date date, int quota, SimpleDateFormat dateWithHour, int eventID, String eventName) {
        super(date, quota, dateWithHour, eventID, eventName);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

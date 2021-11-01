package objects;

import abstractclasses.EngagementAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MeetingObject extends EngagementAbstract {
    private int meetingID;

    public MeetingObject(Date date, SimpleDateFormat dateWithHour, int duration, String[] userIDs, int meetingID) {
        super(date, dateWithHour, duration, userIDs);
        this.meetingID = meetingID;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }
}

package abstractclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CourseAbstract {
    Date date = new Date();
    private int quota;
    private SimpleDateFormat dateWithHour;
    private int courseID;
    private String courseName;
    private int duration = 120;

    public CourseAbstract(Date date, int quota, SimpleDateFormat dateWithHour, int courseID, String courseName) {
        this.date = date;
        this.quota = quota;
        this.dateWithHour = dateWithHour;
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getDateWithHour() {
        return dateWithHour.format(date);
    }

    public void setDateWithHour(SimpleDateFormat dateWithHour) {
        this.dateWithHour = dateWithHour;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

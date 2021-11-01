package objects;

import abstractclasses.CourseAbstract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseObject extends CourseAbstract {

    public CourseObject(Date date, int quota, SimpleDateFormat dateWithHour, int courseID, String courseName) {
        super(date, quota, dateWithHour, courseID, courseName);
    }
}

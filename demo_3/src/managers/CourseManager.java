package managers;

import exceptions.DuplicatedEventException;
import objects.CourseObject;
import objects.TheaterObject;
import utilities.CourseUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CourseManager implements CourseUtilities {
    @Override
    public CourseObject find(ArrayList<CourseObject> courseObjectArrayList,
                             Date date,
                             int quota,
                             SimpleDateFormat formatter,
                             int course_id,
                             String course_name,
                             String txtFile) throws DuplicatedEventException, IOException {

        boolean isContains = false;

        for (CourseObject variable : courseObjectArrayList){
            if (variable.getCourseID()==course_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedEventException("DUPLICATED COURSE ID:" + course_id + " ALREADY EXIST ",txtFile);
        }else{
            return new CourseObject(date,quota,formatter,course_id,course_name);
        }
    }
}

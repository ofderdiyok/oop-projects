package utilities;

import exceptions.DuplicatedEventException;
import objects.CourseObject;
import objects.TheaterObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface CourseUtilities {
    CourseObject find(ArrayList<CourseObject> courseObjectArrayList,
                      Date date,
                      int quota,
                      SimpleDateFormat formatter,
                      int course_id,
                      String course_name,
                      String txtFile
    )throws DuplicatedEventException, IOException;
}

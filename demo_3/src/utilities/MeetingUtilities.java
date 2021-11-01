package utilities;

import exceptions.DuplicatedEventException;
import objects.MeetingObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface MeetingUtilities {
    MeetingObject find(ArrayList<MeetingObject> meetingObjectArrayList,
                       Date date,
                       SimpleDateFormat formatter,
                       int duration,
                       String[] user_ids,
                       int meeting_id,
                       String txtFile)throws DuplicatedEventException, IOException;
}

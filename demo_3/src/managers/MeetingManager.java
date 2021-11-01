package managers;

import exceptions.DuplicatedEventException;
import objects.AppoinmentObject;
import objects.MeetingObject;
import utilities.MeetingUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MeetingManager implements MeetingUtilities {
    @Override
    public MeetingObject find(ArrayList<MeetingObject> meetingObjectArrayList,
                              Date date,
                              SimpleDateFormat formatter,
                              int duration,
                              String[] user_ids,
                              int meeting_id,
                              String txtFile) throws DuplicatedEventException, IOException {
        boolean isContains = false;
        //4
        for (MeetingObject variable : meetingObjectArrayList){
            if (variable.getMeetingID()==meeting_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedEventException("DUPLICATED MEETING ID:" + meeting_id + " ALREADY EXIST ",txtFile);
        }else{
            return new MeetingObject(date,formatter,duration,user_ids,meeting_id);
        }
    }
}

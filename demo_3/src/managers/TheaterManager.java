package managers;

import exceptions.DuplicatedEventException;
import objects.ConcertObject;
import objects.TheaterObject;
import utilities.TheaterUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TheaterManager implements TheaterUtilities {
    @Override
    public TheaterObject find(ArrayList<TheaterObject> theaterObjectArrayList,
                              Date date,
                              int quota,
                              SimpleDateFormat formatter,
                              int event_id,
                              String event_name,
                              String txtFile) throws DuplicatedEventException, IOException {
        boolean isContains = false;

        for (TheaterObject variable : theaterObjectArrayList){
            if (variable.getEventID()==event_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedEventException("DUPLICATED EVENT ID:" + event_id + " ALREADY EXIST ",txtFile);
        }else{
            return new TheaterObject(date,quota,formatter,event_id,event_name);
        }
    }
}

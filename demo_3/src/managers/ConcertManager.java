package managers;

import exceptions.DuplicatedEventException;
import objects.AppoinmentObject;
import objects.ConcertObject;
import utilities.ConcertUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConcertManager implements ConcertUtilities {
    @Override
    public ConcertObject find(ArrayList<ConcertObject> concertObjectArrayList,
                              Date date, int quota,
                              SimpleDateFormat formatter,
                              int event_id,
                              String event_name,
                              String txtFile) throws DuplicatedEventException, IOException {
        boolean isContains = false;

        for (ConcertObject variable : concertObjectArrayList){
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
            return new ConcertObject(date,quota,formatter,event_id,event_name);
        }
    }
}

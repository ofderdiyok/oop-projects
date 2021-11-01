package managers;

import exceptions.DuplicatedEventException;
import utilities.EventUtilities;

import java.io.IOException;
import java.util.ArrayList;

public class EventManager implements EventUtilities {
    @Override
    public String checkVariability(ArrayList<Integer> integerArrayList, int event_id,String EVENT_NAME, String txtFile) throws DuplicatedEventException, IOException {
        boolean isInside = false;
        for (int var:integerArrayList){
            if (var == event_id){
                isInside = true;
                break;
            }
            else{
                isInside=false;
            }
        }

        if (isInside==false){
            return null;
        }
        else {
            throw new DuplicatedEventException("DUPLICATED " + EVENT_NAME + " ID: " + event_id + " ALREADY EXIST",txtFile);
        }
    }
}

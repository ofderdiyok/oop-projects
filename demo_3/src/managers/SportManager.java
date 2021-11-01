package managers;

import exceptions.DuplicatedEventException;
import objects.SportObject;
import objects.TheaterObject;
import utilities.SportUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SportManager implements SportUtilities {

    @Override
    public SportObject find(ArrayList<SportObject> sportObjectArrayList,
                            Date date,
                            int quota,
                            SimpleDateFormat formatter,
                            int event_id,
                            String event_name,
                            String txtFile) throws DuplicatedEventException, IOException {

        boolean isContains = false;

        for (SportObject variable : sportObjectArrayList){
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
            return new SportObject(date,quota,formatter,event_id,event_name);
        }
    }
}

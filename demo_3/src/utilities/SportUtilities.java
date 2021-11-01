package utilities;

import exceptions.DuplicatedEventException;
import objects.SportObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface SportUtilities {
    SportObject find(ArrayList<SportObject> sportObjectArrayList,
                     Date date,
                     int quota,
                     SimpleDateFormat formatter,
                     int event_id,
                     String event_name,
                     String txtFile)throws DuplicatedEventException, IOException;
}

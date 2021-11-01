package utilities;

import exceptions.DuplicatedEventException;
import objects.ConcertObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface ConcertUtilities {
    ConcertObject find(ArrayList<ConcertObject> concertObjectArrayList,
                       Date date,
                       int quota,
                       SimpleDateFormat formatter,
                       int event_id,
                       String event_name,
                       String txtFile)throws DuplicatedEventException, IOException;
}

package utilities;

import exceptions.DuplicatedEventException;
import objects.TheaterObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface TheaterUtilities {
    TheaterObject find(ArrayList<TheaterObject> theaterObjectArrayList,
                       Date date,
                       int quota,
                       SimpleDateFormat formatter,
                       int event_id,
                       String event_name,
                       String txtFile
                       )throws DuplicatedEventException, IOException;
}

package utilities;

import exceptions.DuplicatedEventException;
import objects.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface AppoinmentUtilities {
    AppoinmentObject find(ArrayList<AppoinmentObject> appoinmentObjectArrayList,
                          Date date,
                          SimpleDateFormat formatter,
                          int duration,
                          String[] user_ids,
                          int appoinment_id,
                          String txtfile) throws DuplicatedEventException, IOException;
}

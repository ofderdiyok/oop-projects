package utilities;

import exceptions.DuplicatedAnniversaryException;
import objects.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface AnniversaryUtilities {
    AnniversaryObject find(ArrayList<AnniversaryObject> anniversaryObjectArrayList,
                           int anniversaryID,
                           String txtfile,
                           int userID,
                           String description,
                           SimpleDateFormat formatter,
                           Date date)
                            throws DuplicatedAnniversaryException, IOException;
}

package utilities;

import exceptions.DuplicatedEventException;

import java.io.IOException;
import java.util.ArrayList;

public interface EventUtilities {
    String checkVariability(ArrayList<Integer> integerArrayList, int event_id, String EVENT_NAME , String txtFile)throws DuplicatedEventException, IOException;
}

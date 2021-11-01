package utilities;

import exceptions.DuplicatedEventException;
import objects.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface BirthdayUtilities {
    BirthdayObject find(ArrayList<BirthdayObject> birthdayObjectArrayList,
                        int user_id,
                        Date date,
                        SimpleDateFormat formatter,
                        int birthday_id,
                        String description,
                        String txtfile)throws DuplicatedEventException, IOException;
}

package managers;

import exceptions.DuplicatedEventException;
import objects.*;
import utilities.BirthdayUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BirthdayManager implements BirthdayUtilities {
    @Override
    public BirthdayObject find(ArrayList<BirthdayObject> birthdayObjectArrayList,
                               int user_id,
                               Date date, SimpleDateFormat formatter,
                               int birthday_id, String description,
                               String txtfile) throws DuplicatedEventException, IOException {
        boolean isContains = false;

        //2
        for (BirthdayObject variable : birthdayObjectArrayList){
            if (variable.getBirthDayID()==birthday_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedEventException("DUPLICATED BIRTHDAY ID:" + birthday_id + " ALREADY EXIST ",txtfile);
        }else{
            return new BirthdayObject(user_id,date,formatter,birthday_id,description);
        }
    }


}

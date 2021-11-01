package managers;

import exceptions.DuplicatedEventException;
import objects.*;
import utilities.AppoinmentUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppoinmentManager implements AppoinmentUtilities {

    @Override
    public AppoinmentObject find(ArrayList<AppoinmentObject> appoinmentObjectArrayList,
                                 Date date,
                                 SimpleDateFormat formatter,
                                 int duration,
                                 String[] user_ids,
                                 int appoinment_id,
                                 String txtfile) throws DuplicatedEventException, IOException {
        boolean isContains = false;

        //3
        for (AppoinmentObject variable : appoinmentObjectArrayList){
            if (variable.getAppoinmentID()==appoinment_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedEventException("DUPLICATED APPOINTMENT ID:" + appoinment_id + " ALREADY EXIST ",txtfile);
        }else{
            return new AppoinmentObject(date,formatter,duration,user_ids,appoinment_id);
        }
    }
}

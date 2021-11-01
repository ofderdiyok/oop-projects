package managers;

import exceptions.DuplicatedAnniversaryException;
import objects.*;
import utilities.AnniversaryUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AnniversaryManager implements AnniversaryUtilities {
    @Override
    public AnniversaryObject find(ArrayList<AnniversaryObject> anniversaryObjectArrayList,
                                  int anniversaryID,
                                  String txtfile,
                                  int userID,
                                  String description,
                                  SimpleDateFormat formatter,
                                  Date date) throws DuplicatedAnniversaryException, IOException {
        boolean isContains = false;
        //1
        for (AnniversaryObject variable : anniversaryObjectArrayList){
            if (variable.getAnniversaryID()==anniversaryID){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedAnniversaryException("DUPLICATED ANNIVERSARY ID:" + anniversaryID + " ALREADY EXIST ",txtfile);
        }else{
            return new AnniversaryObject(userID,date,formatter,anniversaryID,description);
        }
    }
}

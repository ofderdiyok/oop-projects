package managers;

import exceptions.DuplicatedUserIdException;
import exceptions.UserNotFoundException;
import objects.UserObject;
import utilities.UserUtilities;

import java.io.IOException;
import java.util.ArrayList;

public class UserManager implements UserUtilities {

    @Override
    public UserObject find(ArrayList<UserObject> userObjectTreeSet, int user_id, String name, String txtfile) throws DuplicatedUserIdException, IOException
    {
        boolean isContains = false;
        for (UserObject variable : userObjectTreeSet){
            if (variable.getUserID()==user_id){
                isContains = true;
                break;
            }else{
                isContains = false;
            }
        }

        if (isContains==true){
            throw new DuplicatedUserIdException("DUPLICATED USER ID:" + user_id + " ALREADY EXIST ",txtfile);
        }else {
            return new UserObject(user_id,name);
        }

    }

    @Override
    public String checkVariability(ArrayList<UserObject> userObjectArrayList, int user_id, String txtfile) throws UserNotFoundException, IOException
    {
        boolean isInside = false;
        for (UserObject variable:userObjectArrayList){
            if (variable.getUserID()==user_id){
                isInside = true;
                break;
            }else{
                isInside = false;
            }
        }

        if (isInside==true){
            return null;
        }else{
            throw new UserNotFoundException("USER NOT FOUND: " + user_id,txtfile);
        }
    }


}

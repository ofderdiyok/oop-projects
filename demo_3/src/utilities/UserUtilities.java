package utilities;

import exceptions.DuplicatedUserIdException;
import exceptions.UserNotFoundException;
import objects.UserObject;

import java.io.IOException;
import java.util.ArrayList;

public interface UserUtilities{

    UserObject find(ArrayList<UserObject> userObjectTreeSet,
                    int user_id,
                    String name,
                    String txtfile) throws DuplicatedUserIdException, IOException;

    String checkVariability(ArrayList<UserObject> userObjectArrayList,
                            int user_id,
                            String txtfile) throws UserNotFoundException, IOException;
}

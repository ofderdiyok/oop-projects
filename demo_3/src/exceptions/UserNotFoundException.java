package exceptions;

import utilities.Methods;

import java.io.IOException;

public class UserNotFoundException extends Exception{
    public UserNotFoundException (String message) {
        super(message);
    }

    public UserNotFoundException (String message, String txtfile) throws IOException {
        super(message);
        Methods.writeFileasString(txtfile,message);
    }
}

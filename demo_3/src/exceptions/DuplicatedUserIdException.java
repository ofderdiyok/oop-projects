package exceptions;

import utilities.Methods;

import java.io.IOException;

public class DuplicatedUserIdException extends Exception{

    public DuplicatedUserIdException(String message) {
        super(message);
    }

    public DuplicatedUserIdException(String message, String txtfile) throws IOException {
        super(message);
        Methods.writeFileasString(txtfile,message);
    }

}

package exceptions;

import utilities.Methods;

import java.io.IOException;

public class DuplicatedAnniversaryException extends Exception{
    public DuplicatedAnniversaryException(String message) {
        super(message);
    }

    public DuplicatedAnniversaryException(String message, String txtfile) throws IOException {
        super(message);
        Methods.writeFileasString(txtfile,message);
    }

}

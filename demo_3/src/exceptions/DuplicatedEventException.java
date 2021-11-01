package exceptions;

import utilities.Methods;

import java.io.IOException;

public class DuplicatedEventException extends Exception
{
    public DuplicatedEventException(String message){
        super(message);
    }

    public DuplicatedEventException(String message, String txtfile) throws IOException {
        super(message);
        Methods.writeFileasString(txtfile,message);
    }
}

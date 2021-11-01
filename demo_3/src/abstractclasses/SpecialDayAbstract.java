package abstractclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class SpecialDayAbstract extends UserAbstract{
    Date date = new Date();
    private SimpleDateFormat dateWithoutHour;

    public SpecialDayAbstract(int userID, Date date, SimpleDateFormat dateWithoutHour ) {
        super(userID);
        this.date = date;
        this.dateWithoutHour=dateWithoutHour;
    }

    public String dateWithoutHour() {
        return dateWithoutHour.format(date);
    }

    public void setDateWithHour(SimpleDateFormat dateWithHour) {
        this.dateWithoutHour = dateWithHour;
    }
}

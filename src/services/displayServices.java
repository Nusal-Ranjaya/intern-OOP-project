package services;

import interfaces.displayInterface;
import java.sql.Date;
import java.sql.Time;

public class displayServices {
    private final displayInterface displayObj;

    public displayServices(displayInterface displayObj) {
        this.displayObj = displayObj;
    }

    public Date readDate(){
        return displayObj.readDate();
    }

    public Time readTime(){
        return displayObj.readTime();
    }

    public Integer readInt(String message){
        return displayObj.readInt(message);
    }

    public Boolean readBooleanFromConsole(String message){
        return displayObj.readBooleanFromConsole(message);
    }

    public String readStringFromConsole(String message){
        return displayObj.readStringFromConsole(message);
    }

    public int  choose(){
        return displayObj.choose();
    }
}

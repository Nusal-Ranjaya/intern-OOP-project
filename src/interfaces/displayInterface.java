package interfaces;
import java.sql.Date;
import java.sql.Time;


public interface displayInterface {
    Date readDate();

    Time readTime();

    Integer readInt(String message);

    Boolean readBooleanFromConsole(String message);

    String readStringFromConsole(String message);

    int  chooseReminder();
    int  chooseSubscriber();
}

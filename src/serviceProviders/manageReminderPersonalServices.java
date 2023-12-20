package serviceProviders;
import interfaces.dataServicesInterface;
import interfaces.displayInterface;
import interfaces.manageReminderInterface;
import services.databaseServices;
import services.displayServices;

public class manageReminderPersonalServices implements manageReminderInterface {

    displayInterface console = new consoleServices();
    displayServices display= new displayServices(console);
    dataServicesInterface dbServicesPostgres =new DatabaseServicesPostgresql();
    databaseServices dbServices = new databaseServices(dbServicesPostgres);
    protected String tableName= "personal";

    public void addReminder(){
        int pk= dbServices.getNumberOfEntries(tableName);
        dbServices.addData(tableName,pk+1, display.readDate(),display.readTime(), display.readInt("Enter priority level: "),display.readBooleanFromConsole("Enter state: "),display.readStringFromConsole("Enter the text:"));
    }
    public void viewReminders(){
        dbServices.getAllData(tableName);
    }

    public void editReminder(){
        dbServices.updateStatus(tableName,display.readInt("id: "), display.readBooleanFromConsole("state(true/false): "));

    }

    public void deleteReminder(){
        dbServices.deleteDataById(tableName,display.readInt("Enter ID: "));
    }
}

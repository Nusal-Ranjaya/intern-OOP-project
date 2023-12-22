package serviceProviders;

import interfaces.manageReminderInterface;
import services.databaseServices;
import services.displayServices;

public class manageReminderPersonalServices implements manageReminderInterface {

    protected String tableName= "personal";

    public void addReminder(displayServices display,databaseServices dbServices ){
        int pk= dbServices.getNumberOfEntries(tableName);
        dbServices.addData(tableName,pk+1, display.readDate(),display.readTime(), display.readInt("Enter priority level: "),display.readBooleanFromConsole("Enter state: "),display.readStringFromConsole("Enter the text:"));
    }
    public void viewReminders(databaseServices dbServices ){
        dbServices.getAllData(tableName);
    }

    public void editReminder(displayServices display,databaseServices dbServices){
        dbServices.updateStatus(tableName,display.readInt("id: "), display.readBooleanFromConsole("state(true/false): "));

    }

    public void deleteReminder(displayServices display,databaseServices dbServices){
        dbServices.deleteDataById(tableName,display.readInt("Enter ID: "));
    }
}

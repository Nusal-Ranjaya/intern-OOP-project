package services;

import interfaces.displayInterface;
import interfaces.manageReminderInterface;
import serviceProviders.consoleServices;
import serviceProviders.manageReminderOfficialServices;
import serviceProviders.manageReminderPersonalServices;

public class reminderFactory {
    manageReminderInterface mR_OfficialObj = new manageReminderOfficialServices();
    manageReminderInterface mR_PersonalObj = new manageReminderPersonalServices();


    displayInterface console = new consoleServices();
    displayServices display= new displayServices(console);



    public manageReminder getReminderObj(){
        int option =display.chooseReminder();
        return switch (option) {
            case 1 -> new manageReminder(mR_PersonalObj);
            case 2 -> new manageReminder(mR_OfficialObj);
            default -> null;
        };
    }

}

package services;

import interfaces.manageReminderInterface;

public class manageReminder {
    private final manageReminderInterface mrObj;

    public manageReminder(manageReminderInterface mrObj) {
        this.mrObj = mrObj;
    }

    public void addReminder(displayServices display, databaseServices dbServices){
        mrObj.addReminder(display,dbServices);
    }

    public void viewReminders(databaseServices dbServices){
        mrObj.viewReminders(dbServices);
    }

    public void editReminder(displayServices display, databaseServices dbServices){
        mrObj.editReminder(display,dbServices);
    }

    public void deleteReminder(displayServices display, databaseServices dbServices){
        mrObj.deleteReminder(display,dbServices);
    }
}

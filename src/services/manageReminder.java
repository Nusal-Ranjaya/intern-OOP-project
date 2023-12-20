package services;

import interfaces.manageReminderInterface;

public class manageReminder {
    private final manageReminderInterface mrObj;

    public manageReminder(manageReminderInterface mrObj) {
        this.mrObj = mrObj;
    }

    public void addReminder(){
        mrObj.addReminder();
    }

    public void viewReminders(){
        mrObj.viewReminders();
    }

    public void editReminder(){
        mrObj.editReminder();
    }

    public void deleteReminder(){
        mrObj.deleteReminder();
    }
}

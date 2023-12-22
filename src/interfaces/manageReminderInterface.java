package interfaces;

import services.databaseServices;
import services.displayServices;

public interface manageReminderInterface {

    void addReminder(displayServices display, databaseServices dbServices);

    void viewReminders(databaseServices dbServices);

    void editReminder(displayServices display, databaseServices dbServices);

    void deleteReminder(displayServices display, databaseServices dbServices);
}

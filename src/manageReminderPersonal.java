import services.ReminderServices;

public class manageReminderPersonal extends ReminderServices {
    @Override
    public void addReminder(String tableName) {
        super.addReminder(tableName);
    }

    @Override
    public void viewReminders(String tableName) {
        super.viewReminders(tableName);
    }

    @Override
    public void editReminder(String tableName, Integer id, Boolean status) {
        super.editReminder(tableName, id, status);
    }

    @Override
    public void deleteReminder(String tableName) {
        super.deleteReminder(tableName);
    }
}

package services;

public abstract  class ReminderServices {

    public void addReminder(String tableName){
        int pk= DatabaseServices.getNumberOfEntries(tableName);
        DatabaseServices.addData(tableName,pk+1, consoleServices.readDate(),consoleServices.readTime(), consoleServices.readInt("Enter priority level: "),consoleServices.readBooleanFromConsole("Enter state: "),consoleServices.readStringFromConsole("Enter the text:"));
    }
    public void viewReminders(String tableName){
        DatabaseServices.getAllData(tableName);
    }

    public void editReminder(String tableName,Integer id,Boolean status){
        DatabaseServices.updateStatus(tableName,id,status);

    }

    public void deleteReminder(String tableName){
        DatabaseServices.deleteDataById(tableName,consoleServices.readInt("Enter ID: "));
    }
}

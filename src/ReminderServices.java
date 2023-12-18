import java.sql.*;

public abstract  class ReminderServices {

    private Integer id;
    private Date date;
    private Time time;
    private Integer priority;
    private Boolean state;
    private String text;



    void addReminder(String tableName){
        int pk= DatabaseServices.getNumberOfEntries(tableName);
        DatabaseServices.addData(tableName,pk+1, consoleServices.readDate(),consoleServices.readTime(),consoleServices.readInt("Enter priority level: "),consoleServices.readBooleanFromConsole("Enter state: "),consoleServices.readStringFromConsole("Enter the text:"));
    }
    void viewReminders(String tableName){
        DatabaseServices.getAllData(tableName);
    }

    void editReminder(String tableName,Integer id,Boolean status){
        DatabaseServices.updateStatus(tableName,id,status);

    }

    void deleteReminder(String tableName){
        DatabaseServices.deleteDataById(tableName,consoleServices.readInt("Enter ID: "));
    }
}

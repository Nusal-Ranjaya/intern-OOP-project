import java.sql.*;

public  class ReminderManager {

    private Integer id;
    private Date date;
    private Time time;
    private Integer priority;
    private Boolean state;
    private String text;



    void addReminder(){
        int choice = consoleServices.choose();
        if(choice==1){
            int pk= DatabaseServices.getNumberOfEntries("personal");
            DatabaseServices.addData("personal",pk+1,consoleServices.readDate(),consoleServices.readTime(),consoleServices.readInt("Enter priority level: "),consoleServices.readBooleanFromConsole("Enter state: "),consoleServices.readStringFromConsole("Enter the text:"));
        }
        else if (choice ==2) {
            int pk= DatabaseServices.getNumberOfEntries("official");
            DatabaseServices.addData("official",pk+1,consoleServices.readDate(),consoleServices.readTime(),consoleServices.readInt("Enter priority level: "),consoleServices.readBooleanFromConsole("Enter state: "),consoleServices.readStringFromConsole("Enter the text:"));
        }
        else{
            System.out.println("Wrong input!");
        }
    }
    static void viewReminders(){
        int choice = consoleServices.choose();
        if(choice==1){
            DatabaseServices.getAllData("personal");
        }
        else if (choice ==2) {
            DatabaseServices.getAllData("personal");
        }
        else{
            System.out.println("Wrong input!");
        }
    }
    static void editReminder(){
        int choice = consoleServices.choose();
        if(choice==1){}
        else if (choice ==2) {}
        else{
            System.out.println("Wrong input!");
        }
    }
    static void deleteReminder(){
        int choice = consoleServices.choose();
        if(choice==1){
            DatabaseServices.deleteDataById("personal",consoleServices.readInt("Enter ID: "));
        }
        else if (choice ==2) {
            DatabaseServices.deleteDataById("official",consoleServices.readInt("Enter ID: "));
        }
        else{
            System.out.println("Wrong input!");
        }
    }
}

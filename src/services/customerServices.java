package services;

import java.sql.SQLException;

public class customerServices {
    public static void addCustomer(){
        int pk= DatabaseServices.getNumberOfEntries("customers");
        DatabaseServices.addDataCustomer(pk+1, consoleServices.readStringFromConsole("Customer name: "), consoleServices.readBooleanFromConsole("Enter subscription(true/false): "), consoleServices.readStringFromConsole("Enter email:"));
    }

    public static void removeCustomer(){
        DatabaseServices.deleteDataById("customers", consoleServices.readInt("Enter id: "));
    }

    public static void mailToAll(){
        try {
            automaticEmailSender.sendEmailsToAllCustomers(consoleServices.readStringFromConsole("subject: "), consoleServices.readStringFromConsole("message:"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCustomer(){
        DatabaseServices.updateStatus("customers", consoleServices.readInt("id: "), consoleServices.readBooleanFromConsole("subscription(true/false): "));
    }
}

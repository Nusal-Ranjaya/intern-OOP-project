package services;

import interfaces.bulkMessageInterface;

import java.sql.SQLException;

public class bulkMessageSender {
    private final bulkMessageInterface bulkMessages;

    public bulkMessageSender(bulkMessageInterface bulkMessages) {
        this.bulkMessages = bulkMessages;
    }

    public void startNotification(String tableName){
        bulkMessages.startNotification(tableName);
    }
    public void sendMessagesAllCustomers(String message, String subject)  {
        try {
            bulkMessages.sendMessagesAllCustomers(message,subject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

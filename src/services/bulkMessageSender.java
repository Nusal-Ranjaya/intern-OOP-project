package services;

import interfaces.bulkMessageInterface;

import java.sql.SQLException;

public class bulkMessageSender {
    private final bulkMessageInterface bulkMessages;

    public bulkMessageSender(bulkMessageInterface bulkMessages) {
        this.bulkMessages = bulkMessages;
    }

    public void startNotification(String tableName,databaseServices dbServices, messageServices messageService){
        bulkMessages.startNotification(tableName,dbServices,messageService);
    }
    public void sendMessagesAllCustomers(String message,String subject,messageServices messageService)  {
        try {
            bulkMessages.sendMessagesAllCustomers(message,subject,messageService);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

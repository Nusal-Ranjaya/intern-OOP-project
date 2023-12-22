package interfaces;

import services.databaseServices;
import services.messageServices;

import java.sql.*;


public interface bulkMessageInterface {
    void startNotification(String tableName,databaseServices dbServices, messageServices messageService);
    void sendMessagesAllCustomers(String message,String subject,messageServices messageService) throws SQLException;
}

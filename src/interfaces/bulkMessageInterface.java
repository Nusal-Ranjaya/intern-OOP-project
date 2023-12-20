package interfaces;

import java.sql.*;


public interface bulkMessageInterface {
    void startNotification(String tableName);
    void sendMessagesAllCustomers(String message, String subject) throws SQLException;
}

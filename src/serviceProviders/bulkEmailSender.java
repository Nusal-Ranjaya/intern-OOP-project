package serviceProviders;
import interfaces.bulkMessageInterface;
import services.databaseServices;
import services.messageServices;
import java.sql.*;
import java.time.LocalDate;

public class bulkEmailSender implements bulkMessageInterface {


    @SuppressWarnings({"UnusedAssignment", "ConstantValue"})
    public void startNotification(String tableName,databaseServices dbServices,messageServices messageService){
        String to = "muthuthanthrigenr.20@uom.lk";
        boolean loop=true;
        do{
            LocalDate date=LocalDate.now();


            String sql = "SELECT * FROM " + tableName;
            try (Connection con = DriverManager.getConnection(DatabaseServicesPostgresql.url, DatabaseServicesPostgresql.userName, DatabaseServicesPostgresql.password);
                 Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                while (rs.next()) {
                     if(rs.getDate(2).toString().equals(date.toString()) && !rs.getBoolean(5)){
                         dbServices.updateStatus(tableName,rs.getInt(1),true);
                         String message=rs.getTime(3).toString()+": "+rs.getString(6);
                         messageService.sendAutoMessage(to,tableName,message);

                     }
                 }
                 loop=false;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
            }

        }while(loop);

    }
    public void sendMessagesAllCustomers(String message,String subject,messageServices messageService) throws SQLException {
        String sql = "SELECT * FROM customers ";
        try (Connection con = DriverManager.getConnection(DatabaseServicesPostgresql.url, DatabaseServicesPostgresql.userName, DatabaseServicesPostgresql.password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getBoolean(3)) {
                    messageService.sendAutoMessage(rs.getString(4), subject, message);

                }
            }

        }
    }
}

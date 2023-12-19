package services;
import java.sql.*;
import java.time.LocalDate;

public class automaticEmailSender  {

    public static void startNotification(String tableName){
        String to = "muthuthanthrigenr.20@uom.lk";
        boolean loop=true;
        do{
            LocalDate date=LocalDate.now();


            String sql = "SELECT * FROM " + tableName;
            try (Connection con = DriverManager.getConnection(DatabaseServices.url,DatabaseServices.userName,DatabaseServices.password);
                 Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                 ResultSetMetaData metaData = rs.getMetaData();
                 int columnCount = metaData.getColumnCount();

                 while (rs.next()) {
                     if(rs.getDate(2).toString().equals(date.toString()) && !rs.getBoolean(5)){
                         DatabaseServices.updateStatus(tableName,rs.getInt(1),true);
                         String message=rs.getTime(3).toString()+": "+rs.getString(6);
                         mailServices.sendEmailAuto(to,tableName,message);

                     }
                 }
                 loop=false;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
            }

        }while(loop);

    }
    public static void sendEmailsToAllCustomers(String message,String subject) throws SQLException {
        String sql = "SELECT * FROM customers ";
        try (Connection con = DriverManager.getConnection(DatabaseServices.url, DatabaseServices.userName, DatabaseServices.password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                if (rs.getBoolean(3)) {
                    mailServices.sendEmailAuto(rs.getString(4), subject, message);

                }
            }

        }
    }
}

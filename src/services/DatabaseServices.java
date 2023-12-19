package services;

import java.sql.*;

public class DatabaseServices {

    public static String url = "jdbc:postgresql://localhost:5432/intern_OOP";
    public static String userName = "postgres";
    public static String password = "root";

    static String result;
    static int entryNUM;

    public static void getAllData(String tableName) {
        String sql = "SELECT * FROM " + tableName;

        try (Connection con = DriverManager.getConnection(url, userName, password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getData(String columnName, String tableName, Integer id) {
        String sql1 = "SELECT " + columnName + " FROM " + tableName + " WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql1)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                result = rs.getString(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void deleteDataById(String tableName, int id) {
        String sql2 = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql2)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data with ID " + id + " deleted successfully.");

                String updateSql = "UPDATE " + tableName + " SET id = id - 1 WHERE id > ?";
                try(PreparedStatement update = con.prepareStatement(updateSql)){
                    update.setInt(1,id);
                    update.executeUpdate();
                }catch (SQLException e){
                    throw new RuntimeException(e);
                }

            } else {
                System.out.println("No data found with ID " + id + ".");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addData(String tableName, Integer id, Date date, Time time, Integer priority, Boolean state, String text) {
        String sql = "INSERT INTO " + tableName + " (id, date, time, priority, state, text) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, date);
            preparedStatement.setTime(3, time);
            preparedStatement.setInt(4, priority);
            preparedStatement.setBoolean(5, state);
            preparedStatement.setString(6, text);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully inserted data.");
            } else {
                System.out.println("Error inserting data.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStatus(String tableName,Integer id,Boolean status){
        String sql5 = "UPDATE " + tableName + " SET state = ? WHERE id = ?";

        try(Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql5);){

            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getNumberOfEntries(String tableName) {
        String sql4 = "SELECT COUNT(*) AS total_entries FROM " + tableName;

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql4);
             ResultSet rs = preparedStatement.executeQuery()) {

            rs.next();
            entryNUM = rs.getInt("total_entries");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entryNUM;
    }

    public static void addDataCustomer(Integer id,String name,Boolean subscribe, String text) {
        String sql = "INSERT INTO  customers" + " (id, name,state,email) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, subscribe);
            preparedStatement.setString(4, text);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully inserted data.");
            } else {
                System.out.println("Error inserting data.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

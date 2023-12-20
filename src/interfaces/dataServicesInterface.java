package interfaces;
import java.sql.*;

public interface dataServicesInterface {

    void getAllData(String tableName);

    @SuppressWarnings("UnusedReturnValue")
    String getData(String columnName, String tableName, Integer id);


    void deleteDataById(String tableName, int id);

    void addData(String tableName, Integer id, Date date, Time time, Integer priority, Boolean state, String text);

    void updateStatus(String tableName,Integer id,Boolean status);


    int getNumberOfEntries(String tableName);

    void addDataCustomer(Integer id,String name,Boolean subscribe, String text);
}

package services;
import interfaces.dataServicesInterface;
import java.sql.Date;
import java.sql.Time;

public class databaseServices {

    private final dataServicesInterface database;

    public databaseServices(dataServicesInterface database) {
        this.database = database;
    }

    public void getAllData(String tableName){
        database.getAllData(tableName);
    }

    @SuppressWarnings("unused")
    public void getData(String columnName, String tableName, Integer id){
        database.getData(columnName,tableName,id);
    }


    public void deleteDataById(String tableName, int id) {
        database.deleteDataById(tableName,id);
    }

    public void addData(String tableName, Integer id, Date date, Time time, Integer priority, Boolean state, String text){
        database.addData(tableName,id,date,time,priority,state,text);
    }

    public void updateStatus(String tableName,Integer id,Boolean status){
        database.updateStatus(tableName,id,status);
    }


    public int getNumberOfEntries(String tableName){
        return database.getNumberOfEntries(tableName);
    }

    public void addDataCustomer(Integer id,String name,Boolean subscribe, String text){
        database.addDataCustomer(id,name,subscribe,text);
    }
}

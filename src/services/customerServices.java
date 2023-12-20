package services;

import interfaces.bulkMessageInterface;
import interfaces.dataServicesInterface;
import interfaces.displayInterface;
import serviceProviders.DatabaseServicesPostgresql;
import serviceProviders.bulkEmailSender;
import serviceProviders.consoleServices;


public class customerServices {
    displayInterface console = new consoleServices();
    displayServices display= new displayServices(console);
    bulkMessageInterface emailBulk = new bulkEmailSender();
    bulkMessageSender bulkMessage= new bulkMessageSender(emailBulk);

    dataServicesInterface dbServicesPost =new DatabaseServicesPostgresql();
    databaseServices dbServices = new databaseServices(dbServicesPost);
    public void addCustomer(){
        int pk= dbServices.getNumberOfEntries("customers");
        dbServices.addDataCustomer(pk+1, display.readStringFromConsole("Customer name: "), display.readBooleanFromConsole("Enter subscription(true/false): "), display.readStringFromConsole("Enter email:"));
    }

    public void removeCustomer(){
        dbServices.deleteDataById("customers", display.readInt("Enter id: "));
    }

    public void mailToAll(){
        bulkMessage.sendMessagesAllCustomers(display.readStringFromConsole("subject: "), display.readStringFromConsole("message:"));
    }

    public void updateCustomer(){
        dbServices.updateStatus("customers", display.readInt("id: "), display.readBooleanFromConsole("subscription(true/false): "));
    }

    public void getAllCustomerData(){
        dbServices.getAllData("customers");
    }
}

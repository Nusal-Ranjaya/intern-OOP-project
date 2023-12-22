package serviceProviders;

import interfaces.subscriberInterface;
import services.bulkMessageSender;
import services.databaseServices;
import services.displayServices;
import services.messageServices;


public class customerServices implements subscriberInterface {


    public void addSubscriber(displayServices display,databaseServices dbServices){
        int pk= dbServices.getNumberOfEntries("customers");
        dbServices.addDataCustomer(pk+1, display.readStringFromConsole("Customer name: "), display.readBooleanFromConsole("Enter subscription(true/false): "), display.readStringFromConsole("Enter email:"));
    }

    public void removeSubscriber(displayServices display,databaseServices dbServices){
        dbServices.deleteDataById("customers", display.readInt("Enter id: "));
    }

    public void mailToAll(displayServices display,bulkMessageSender bulkMessage,messageServices messageService){
        bulkMessage.sendMessagesAllCustomers(display.readStringFromConsole("subject: "), display.readStringFromConsole("message:"),messageService);
    }

    public void updateSubscriber(displayServices display,databaseServices dbServices){
        dbServices.updateStatus("customers", display.readInt("id: "), display.readBooleanFromConsole("subscription(true/false): "));
    }

    public void getAllSubscriberData(databaseServices dbServices){
        dbServices.getAllData("customers");
    }
}

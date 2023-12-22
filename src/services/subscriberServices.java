package services;

import interfaces.subscriberInterface;

public class subscriberServices {
    private final subscriberInterface subObj;

    public subscriberServices(subscriberInterface subObj) {
        this.subObj = subObj;
    }

    public void addSubscriber(displayServices display, databaseServices dbServices){
        subObj.addSubscriber(display,dbServices);
    }

    public void removeSubscriber(displayServices display,databaseServices dbServices){
        subObj.removeSubscriber(display,dbServices);
    }

    public void mailToAll(displayServices display, bulkMessageSender bulkMessage, messageServices messageService){
        subObj.mailToAll(display,bulkMessage,messageService);
    }

    public void updateSubscriber(displayServices display,databaseServices dbServices){
        subObj.updateSubscriber(display,dbServices);
    }

    public void getAllSubscriberData(databaseServices dbServices){
        subObj.getAllSubscriberData(dbServices);
    }
}

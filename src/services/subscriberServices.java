package services;

import interfaces.subscriberInterface;

public class subscriberServices {
    private final subscriberInterface subObj;

    public subscriberServices(subscriberInterface subObj) {
        this.subObj = subObj;
    }

    public void addSubscriber(){
        subObj.addSubscriber();
    }

    public void removeSubscriber(){
        subObj.removeSubscriber();
    }

    public void mailToAll(){
        subObj.mailToAll();
    }

    public void updateSubscriber(){
        subObj.updateSubscriber();
    }

    public void getAllSubscriberData(){
        subObj.getAllSubscriberData();
    }
}

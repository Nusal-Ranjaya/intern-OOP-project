package services;

import interfaces.displayInterface;
import interfaces.subscriberInterface;
import serviceProviders.consoleServices;
import serviceProviders.customerServices;

public class subscriberFactory {
    subscriberInterface customer = new customerServices();
    displayInterface console = new consoleServices();
    displayServices display= new displayServices(console);



    public subscriberServices getSubscriberObj(){
        int option =display.chooseSubscriber();
        subscriberServices returnObj = null;
        switch(option){
            case 1:
                returnObj = new subscriberServices(customer);;
                break;

        }
        return returnObj;
    }
}

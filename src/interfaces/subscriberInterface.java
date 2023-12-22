package interfaces;

import services.bulkMessageSender;
import services.databaseServices;
import services.displayServices;
import services.messageServices;

public interface subscriberInterface {
    void addSubscriber(displayServices display, databaseServices dbServices);

    void removeSubscriber(displayServices display,databaseServices dbServices);

    void mailToAll(displayServices display, bulkMessageSender bulkMessage, messageServices messageService);

    void updateSubscriber(displayServices display,databaseServices dbServices);

    void getAllSubscriberData(databaseServices dbServices);
}
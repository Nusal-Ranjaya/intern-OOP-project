package interfaces;

import services.displayServices;

public interface messageServicesInterface {
    void sendMessage(displayServices display);

    void sendAutoMessage(String to, String subject, String message);
}

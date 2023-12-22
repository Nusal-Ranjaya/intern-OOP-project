package services;

import interfaces.messageServicesInterface;

public class messageServices {
    private final messageServicesInterface messageObj;

    public messageServices(messageServicesInterface messageObj) {
        this.messageObj = messageObj;
    }
    public void sendMessage(displayServices display){
        messageObj.sendMessage(display);
    }

    public void sendAutoMessage(String to, String subject, String message){
        messageObj.sendAutoMessage(to,subject,message);
    }
}

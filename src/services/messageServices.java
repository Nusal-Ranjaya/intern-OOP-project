package services;

import interfaces.messageServicesInterface;

public class messageServices {
    private final messageServicesInterface messageObj;

    public messageServices(messageServicesInterface messageObj) {
        this.messageObj = messageObj;
    }
    public void sendMessage(){
        messageObj.sendMessage();
    }

    public void sendAutoMessage(String to, String subject, String message){
        messageObj.sendAutoMessage(to,subject,message);
    }
}

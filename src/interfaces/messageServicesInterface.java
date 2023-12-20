package interfaces;

public interface messageServicesInterface {
    void sendMessage();

    void sendAutoMessage(String to, String subject, String message);
}

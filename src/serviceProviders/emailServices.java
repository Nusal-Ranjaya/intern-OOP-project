package serviceProviders;
import configurations.EmailConfig;
import interfaces.displayInterface;
import interfaces.messageServicesInterface;
import services.displayServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailServices implements messageServicesInterface {
    displayInterface console = new consoleServices();
    displayServices display= new displayServices(console);

    public void sendMessage() {

        String to =display.readStringFromConsole("to: ");

        if (mailVerify(to)) {
            System.out.println("Check the given email address");
        } else {
            EmailConfig email1 = new EmailConfig(to,display.readStringFromConsole("subject: "), display.readStringFromConsole("message: "));
            email1.sendActualEmail();
        }
    }

    public void sendAutoMessage(String to, String subject, String message) {

        if (mailVerify(to)) {
            System.out.println("Check the given email address");
        } else {
            EmailConfig email1 = new EmailConfig(to, subject, message);
            email1.sendActualEmail();
        }
    }

    protected boolean mailVerify(String address) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return !matcher.matches();
    }


}

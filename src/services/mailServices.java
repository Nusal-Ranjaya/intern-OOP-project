package services;

import configurations.EmailConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mailServices {
    public static void sendEmail() {
        String to, subject, message;
        Scanner in = new Scanner(System.in);

        System.out.println("To :");
        to = in.nextLine();
        if (!mailVarify(to)) {
            System.out.println("Check the given email address");
        } else {
            System.out.println("Subject :");
            subject = in.nextLine();
            System.out.println("Message :");
            message = in.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now);
            EmailConfig email1 = new EmailConfig(to, subject, message, currentDate);
            email1.sendActualEmail();
        }
    }

    public static void sendEmailAuto(String to, String subject, String message) {

        if (!mailVarify(to)) {
            System.out.println("Check the given email address");
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now);
            EmailConfig email1 = new EmailConfig(to, subject, message, currentDate);
            email1.sendActualEmail();
        }
    }

    public static boolean mailVarify(String address) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }


}

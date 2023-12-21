import interfaces.*;
import serviceProviders.*;
import services.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args)  {

        reminderFactory factoryR= new reminderFactory();
        subscriberFactory factoryS = new subscriberFactory();

        messageServicesInterface email= new emailServices();
        messageServices messageService = new messageServices(email);

        bulkMessageInterface emailBulk = new bulkEmailSender();
        bulkMessageSender bulkMessage= new bulkMessageSender(emailBulk);


        do {
            //send automatic email if there's reminder to be sent
            bulkMessage.startNotification("personal");
            bulkMessage.startNotification("official");

            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Enter option type:\s
                    1 - set a new reminder
                    2 - view all reminders
                    3 - edit a current reminder state
                    4 - delete a reminder
                    5 - Add new subscriber
                    6 - view all subscribers
                    7 - change subscriber subscription
                    8 - Remove subscriber from the table
                    9 - send an email
                    10 - send email to all subscriber""");
            int option;
            try {
                option = scanner.nextInt();
            }catch(NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong input");

                continue;
            }

            switch(option){
                case 1:
                    factoryR.getReminderObj().addReminder();
                    break;
                case 2:
                    factoryR.getReminderObj().viewReminders();
                    break;
                case 3:
                    factoryR.getReminderObj().editReminder();
                    break;
                case 4:
                    factoryR.getReminderObj().deleteReminder();
                    break;
                case 5:
                    factoryS.getSubscriberObj().addSubscriber();
                    break;
                case 6:
                    factoryS.getSubscriberObj().getAllSubscriberData();
                    break;
                case 7:
                    factoryS.getSubscriberObj().updateSubscriber();
                    break;
                case 8:
                    factoryS.getSubscriberObj().removeSubscriber();
                    break;
                case 9:
                    messageService.sendMessage();
                    break;
                case 10:
                    factoryS.getSubscriberObj().mailToAll();
                    break;
            }
        }while(true);


    }
}
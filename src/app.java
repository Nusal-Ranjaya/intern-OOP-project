import interfaces.*;
import serviceProviders.*;
import services.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args)  {

        // ALl objects needed
        displayInterface console = new consoleServices();//console
        displayServices display= new displayServices(console);

        dataServicesInterface dbServicesPost =new DatabaseServicesPostgresql();//postgresql
        databaseServices dbServices = new databaseServices(dbServicesPost);

        messageServicesInterface email= new emailServices();//email
        messageServices messageService = new messageServices(email);

        bulkMessageInterface emailBulk = new bulkEmailSender();//email
        bulkMessageSender bulkMessage= new bulkMessageSender(emailBulk);

        ////////////////////
        reminderFactory factoryR= new reminderFactory();
        subscriberFactory factoryS = new subscriberFactory();

        ////////////////////

        do {
            //send automatic email if there's reminder to be sent
            bulkMessage.startNotification("personal",dbServices,messageService);
            bulkMessage.startNotification("official",dbServices,messageService);

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
                    factoryR.getReminderObj().addReminder(display,dbServices);
                    break;
                case 2:
                    factoryR.getReminderObj().viewReminders(dbServices);
                    break;
                case 3:
                    factoryR.getReminderObj().editReminder(display,dbServices);
                    break;
                case 4:
                    factoryR.getReminderObj().deleteReminder(display,dbServices);
                    break;
                case 5:
                    factoryS.getSubscriberObj().addSubscriber(display,dbServices);
                    break;
                case 6:
                    factoryS.getSubscriberObj().getAllSubscriberData(dbServices);
                    break;
                case 7:
                    factoryS.getSubscriberObj().updateSubscriber(display,dbServices);
                    break;
                case 8:
                    factoryS.getSubscriberObj().removeSubscriber(display,dbServices);
                    break;
                case 9:
                    messageService.sendMessage(display);
                    break;
                case 10:
                    factoryS.getSubscriberObj().mailToAll(display,bulkMessage,messageService);
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }while(true);


    }
}
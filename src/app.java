import interfaces.*;
import serviceProviders.*;
import services.*;
import serviceProviders.manageReminderOfficialServices;
import serviceProviders.manageReminderPersonalServices;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args)  {
        manageReminderInterface mR_OfficialObj = new manageReminderOfficialServices();
        manageReminderInterface mR_PersonalObj = new manageReminderPersonalServices();
        manageReminder mR_Official = new manageReminder(mR_OfficialObj);
        manageReminder mR_Personal = new manageReminder(mR_PersonalObj);

        customerServices customerServices = new customerServices();

        displayInterface console = new consoleServices();
        displayServices display= new displayServices(console);

        messageServicesInterface email= new emailServices();
        messageServices messageService = new messageServices(email);

        bulkMessageInterface emailBulk = new bulkEmailSender();
        bulkMessageSender bulkMessage= new bulkMessageSender(emailBulk);

        subscriberInterface customer = new customerServices();
        subscriberServices subService = new subscriberServices(customer);


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
                    5 - Add new customer
                    6 - view all customers
                    7 - change customer subscription
                    8 - Remove customer from the table
                    9 - send an email
                    10 - send email to all customers""");
            int option;
            try {
                option = scanner.nextInt();
            }catch(NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong input");

                continue;
            }

            switch(option){
                case 1:
                    int choice = display.choose();
                    if(choice==1){
                        mR_Personal.addReminder();
                    }
                    else if (choice ==2) {
                        mR_Official.addReminder();
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 2:
                    int choice1 = display.choose();
                    if(choice1==1){
                        mR_Personal.viewReminders();
                    }
                    else if (choice1 ==2) {
                        mR_Official.viewReminders();
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 3:
                    int choice2 = display.choose();
                    if(choice2==1){
                        mR_Personal.editReminder();
                    }
                    else if (choice2 ==2) {
                        mR_Official.editReminder();
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 4:
                    int choice3 = display.choose();
                    if(choice3==1){

                        mR_Personal.deleteReminder();
                    }
                    else if (choice3 ==2) {
                        mR_Official.deleteReminder();
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 5:
                    subService.addSubscriber();
                    break;
                case 6:
                    subService.getAllSubscriberData();
                    break;
                case 7:
                    subService.updateSubscriber();
                    break;
                case 8:
                    subService.removeSubscriber();
                    break;
                case 9:
                    messageService.sendMessage();
                    break;
                case 10:
                    subService.mailToAll();
                    break;
            }
        }while(true);


    }
}
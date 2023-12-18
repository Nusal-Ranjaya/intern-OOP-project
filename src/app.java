import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args)  {

        do {
            //send automatic email if there's reminder to be sent
            automaticEmailSender.startNotification("personal");
            automaticEmailSender.startNotification("official");

            String input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                    + "1 - set a new reminder\n"
                    + "2 - view all reminders\n"
                    + "3 - edit a current reminder state\n"
                    + "4 - delete a reminder\n"
                    + "5 - Add new customer\n"
                    + "6 - view all customers\n"
                    + "7 - change customer subscription\n"
                    + "8 - Remove customer from the table\n"
                    + "9 - send an email\n"
                    + "10 - send email to all customers");
            int option = 0;
            try {
                option = scanner.nextInt();
            }catch(NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong input");

                continue;
            }

            Scanner in = new Scanner(System.in);

             manageReminderOfficial mR_Official = new manageReminderOfficial();
             manageReminderPersonal mR_Personal = new manageReminderPersonal();

            switch(option){
                case 1:
                    int choice = consoleServices.choose();
                    if(choice==1){
                        mR_Personal.addReminder("personal");
                    }
                    else if (choice ==2) {
                        mR_Official.addReminder("official");
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 2:
                    int choice1 = consoleServices.choose();
                    if(choice1==1){
                        mR_Personal.viewReminders("personal");
                    }
                    else if (choice1 ==2) {
                        mR_Official.viewReminders("official");
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 3:
                    int choice2 = consoleServices.choose();
                    if(choice2==1){
                        mR_Personal.editReminder("personal",consoleServices.readInt("id: "), consoleServices.readBooleanFromConsole("state(true/false): "));
                    }
                    else if (choice2 ==2) {
                        mR_Official.editReminder("official",consoleServices.readInt("id: "),consoleServices.readBooleanFromConsole("state(true/false): "));
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 4:
                    int choice3 = consoleServices.choose();
                    if(choice3==1){

                        mR_Personal.deleteReminder("personal");
                    }
                    else if (choice3 ==2) {
                        mR_Official.deleteReminder("official");
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    break;
                case 5:
                    customerServices.addCustomer();
                    break;
                case 6:
                    DatabaseServices.getAllData("customers");
                    break;
                case 7:
                    customerServices.updateCustomer();
                    break;
                case 8:
                    customerServices.removeCustomer();
                    break;
                case 9:
                    mailServices.sendEmail();
                    break;
                case 10:
                    customerServices.mailToAll();
                    break;
            }
        }while(true);

    }
}
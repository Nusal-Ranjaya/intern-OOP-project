import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        do {
            automaticEmailSender.startNotification("personal");
            automaticEmailSender.startNotification("official");

            String input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                    + "1 - set a new reminder\n"
                    + "2 - view all reminders\n"
                    + "3 - edit a current reminder status\n"
                    + "4 - delete a reminder\n"
                    + "5 - send an email");
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
                        System.out.println("id: ");
                        int id = in.nextInt();
                        System.out.println("status (true/false): ");
                        Boolean status = in.nextBoolean();
                        mR_Personal.editReminder("personal",id,status);
                    }
                    else if (choice2 ==2) {
                        System.out.println("id: ");
                        int id = in.nextInt();
                        System.out.println("state (true/false): ");
                        Boolean status = in.nextBoolean();
                        mR_Official.editReminder("official",id,status);
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
                    mailServices.sendEmail();
                    break;
            }


        }while(true);

    }
}
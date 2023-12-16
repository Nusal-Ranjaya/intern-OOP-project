import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        do {
            String input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                    + "1 - set a new reminder\n"
                    + "2 - view all reminders\n"
                    + "3 - edit a current reminder\n"
                    + "4 - delete a reminder\n"
                    + "5 - send an email");
            int option = 0;
            try {
                option = scanner.nextInt();
            }catch(NumberFormatException e) {
                System.out.println("Wrong input");

                continue;
            }catch(InputMismatchException e) {
                System.out.println("Wrong input");

                continue;
            }

            Scanner in = new Scanner(System.in);

            ReminderManager rm = new ReminderManager();
           // manageReminderPersonal mR_Personal = new manageReminderPersonal();
            manageMails mE = new manageMails();

            switch(option){
                case 1:
                    rm.addReminder();
                    break;
                case 2:
                    ReminderManager.viewReminders();
                    break;
                case 3:
                    ReminderManager.editReminder();
                    break;
                case 4:
                    ReminderManager.deleteReminder();
                    break;
                case 5:
                    mE.sendEmail();
                    break;
            }


        }while(true);

    }
}
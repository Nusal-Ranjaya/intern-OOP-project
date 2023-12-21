package serviceProviders;
import interfaces.displayInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class consoleServices implements displayInterface {

    public Date readDate(){
        String dateString = readStringFromConsole("Enter date (YYYY-MM-DD): ");
        return Date.valueOf(dateString);
    }

    public Time readTime() {Scanner scanner = new Scanner(System.in);

        System.out.print("Enter time (HH:MM): ");
        String timeString = scanner.nextLine();

        // Define the expected time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            // Parse the time string into a LocalTime object
            LocalTime localTime = LocalTime.parse(timeString, formatter);
            return Time.valueOf(localTime);
        } catch (Exception e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
            // You might want to handle the exception or prompt the user again
            throw new IllegalArgumentException("Invalid time format", e);
        }
    }

    public Integer readInt(String message){
        System.out.println(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean readBooleanFromConsole(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Error reading boolean from console.", e);
        }
    }

    public String readStringFromConsole(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading string from console.", e);
        }
    }

    public int  chooseReminder(){
        int val=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter option type:\s
                1 - personal
                2 - official""");
        int option = 0;
        try {
            option = scanner.nextInt();
        }catch(NumberFormatException e) {
            System.out.println("Wrong input");
        }

        val = switch (option) {
            case 1 -> 1;
            case 2 -> 2;
            default -> val;
        };
        return val;
    }
    public int  chooseSubscriber(){
        int val=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter option type:\s
                1 - customer""");
        int option = 0;
        try {
            option = scanner.nextInt();
        }catch(NumberFormatException e) {
            System.out.println("Wrong input");
        }

        val = switch (option) {
            case 1 -> 1;
            default -> val;
        };
        return val;
    }


}
